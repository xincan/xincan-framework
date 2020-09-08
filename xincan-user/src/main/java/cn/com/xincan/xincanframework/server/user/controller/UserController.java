package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.entity.user.dto.UserPatchDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.common.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.common.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息控制层
 * @create 2020/3/19 14:37
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:37             0.0.1                         用户信息控制层
 */
@Slf4j
@Api(tags = {"用户信息管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Qualifier("userService")
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "查询所有用户信息")
    @GetMapping
    public ResponseObject<List<UserSearchVo>> find() {
        List<UserSearchVo> lists = userService.findAll();
        return ResponseResult.success(lists.size(), lists);
    }

    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "根据用户ID查询用户详细信息")
    @GetMapping("/{id}")
    public ResponseObject<UserSearchVo> findUserById(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
            @NotBlank(message = "用户ID不能为空")
            @Length(message = "用户ID长度应为32位", min = 32, max = 32)
            @PathVariable(name = "id")
            @Valid
            String id
    ) {
        return ResponseResult.success(userService.findUserById(id));
    }

    @ApiOperation(value = "查询用户信息（分页）", httpMethod = "POST", notes = "根据参数列表查询部分用户列表信息")
    @PostMapping("/page")
    public ResponseObject<List<UserSearchVo>> page(@ApiParam @Valid @RequestBody UserSearchDto userSearchDto) {
        Page<UserSearchVo> page = userService.page(userSearchDto);
        return ResponseResult.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "PUT", notes = "新增用户信息")
    @PutMapping
    public ResponseObject<UserSearchVo> save(@ApiParam @Valid UserSaveDto userSaveDto) {
        return ResponseResult.success(userService.save(userSaveDto));
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "PATCH", notes = "根据参数列表修改用户信息")
    @PatchMapping
    public ResponseObject<UserSearchVo> patch(@ApiParam @Valid UserPatchDto userPatchDto) {
        return ResponseResult.success(userService.patch(userPatchDto));
    }

    @ApiOperation(value = "删除用户信息", httpMethod = "DELETE", notes = "根据ID删除用户信息")
    @DeleteMapping
    public ResponseObject<Integer> delete(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
            @NotBlank(message = "用户ID不能为空")
            @Length(message = "用户ID长度应为32位", min = 32, max = 32)
            @RequestParam(name = "id")
            @Valid
            String id
    ) {
        return ResponseResult.success(1, userService.delete(id));
    }



}
