package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.common.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.common.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return ResponseResult.success(userService.findAll());
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "PUT", notes = "新增用户信息")
    @PutMapping
    public ResponseObject<UserSearchVo> save(@ApiParam UserSaveDto userSaveDto) {
        return ResponseResult.success(userService.save(userSaveDto));
    }

    @ApiOperation(value = "根据用户ID查询用户信息", httpMethod = "GET", notes = "根据用户ID查询用户详细信息")
    @GetMapping("/{id}")
    public ResponseObject<UserSearchVo> findUserById(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "1269912454821879810")
            @Validated @PathVariable(name = "id") String id
    ) {
        return ResponseResult.success(userService.findUserById(id));
    }

}
