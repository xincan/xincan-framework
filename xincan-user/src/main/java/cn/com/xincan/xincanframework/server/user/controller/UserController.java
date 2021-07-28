package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.config.excetion.UserException;
import cn.com.xincan.xincanframework.entity.user.dto.UserPatchDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserOrderSearchVo;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import cn.com.xincan.xincanframework.utils.response.ResponseResultBody;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息控制层
 * @create 2020/3/19 14:37
 */
@Slf4j
@Api(tags = {"用户信息管理"})
@RestController
@RequestMapping("/user")
@Validated
@ResponseResultBody
public class UserController {

    private static final int TYPE = 500;

    @Qualifier("userService")
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "用户登录查询", httpMethod = "POST", notes = "根据用户名密码登录用户信息")
    @PostMapping("login")
    @SentinelResource
    public UserSearchVo login(
            @ApiParam(name = "loginName", value = "用户登录名称", required = true, example = "zhangsan")
            @NotBlank(message = "用户登录名称不能为空")
            @Length(message = "用户登录名称长度应为{min}~{max}之间", min = 5, max = 25)
            @RequestParam(name = "loginName") String loginName,

            @ApiParam(name = "password", value = "用户登录密码", required = true, example = "123456")
            @NotNull(message = "用户登录密码不能为空")
            @RequestParam(name = "password") String password
    ) {
        return userService.findUserByParams(loginName, password);
    }

    @ApiOperation(value = "用户退出登录", httpMethod = "POST", notes = "根据用户名密码退出用户信息")
    @PostMapping("out")
    @SentinelResource
    public int logout(
            @ApiParam(name = "loginName", value = "用户登录名称", required = true, example = "zhangsan")
            @NotBlank(message = "用户登录名称不能为空")
            @Length(message = "用户登录名称长度应为{min}~{max}之间", min = 5, max = 25)
            @RequestParam(name = "loginName") String loginName,

            @ApiParam(name = "password", value = "用户登录密码", required = true, example = "123456")
            @NotNull(message = "用户登录密码不能为空")
            @RequestParam(name = "password") String password
    ) {
        return userService.logout(loginName, password);
    }


    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "根据用户ID查询用户详细信息")
    @GetMapping("/{id}/{type}")
    @SentinelResource("/user/{id}/{type}")
    public UserOrderSearchVo findUserById(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "1285759156342562818")
            @NotNull(message = "用户ID不能为空")
            @Length(message = "用户ID长度应为{min}位", min = 19, max = 19)
            @PathVariable(name = "id")
            String id,
            @ApiParam(name = "type", value = "异常类型", required = true, example = "503")
            @NotNull(message = "异常类型不能为空")
            @PathVariable(name = "type")
            Integer type
    ) {
        if(type == TYPE){
            throw new UserException(ResponseCode.BUSINESS_EXCEPTION, "用户信息异常");
        }
        return userService.findUserById(id);
    }

    @ApiOperation(value = "查询所有用户信息", httpMethod = "GET", notes = "查询所有用户信息")
    @GetMapping
    @SentinelResource("/get/user")
    public ResponseObject<List<UserSearchVo>> find() {
        List<UserSearchVo> lists = userService.findAll();
        return ResponseResult.success(lists.size(), lists);
    }

    @ApiOperation(value = "查询用户信息（分页）", httpMethod = "POST", notes = "根据参数列表查询部分用户列表信息")
    @PostMapping
    @SentinelResource("/post/user")
    public ResponseObject<List<UserSearchVo>> page(@ApiParam @Validated @RequestBody UserSearchDto userSearchDto) {
        Page<UserSearchVo> page = userService.page(userSearchDto);
        return ResponseResult.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "PUT", notes = "新增用户信息")
    @PutMapping
    @SentinelResource("/put/user")
    public UserSearchVo save(@ApiParam @Validated UserSaveDto userSaveDto) {
        return userService.save(userSaveDto);
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "PATCH", notes = "根据参数列表修改用户信息")
    @PatchMapping
    @SentinelResource("/patch/user")
    public UserSearchVo patch(@ApiParam @Validated UserPatchDto userPatchDto) {
        return userService.patch(userPatchDto);
    }

    @ApiOperation(value = "删除用户信息", httpMethod = "DELETE", notes = "根据ID删除用户信息")
    @DeleteMapping
    @SentinelResource("/delete/user")
    public Integer delete(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "1285759156342562818")
            @NotNull(message = "用户ID不能为空")
            @Length(message = "用户ID长度应为{max}位", min = 19, max = 19)
            @RequestParam(name = "id")
            String id
    ) {
        return userService.delete(id);
    }

}
