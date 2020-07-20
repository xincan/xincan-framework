package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.common.ResponseObject;
import cn.com.xincan.xincanframework.common.ResponseResult;
import cn.com.xincan.xincanframework.server.user.dto.UserDTO;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.server.user.vo.UserVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 用户信息控制层
 * @create 2020/3/19 14:37
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:37             1.0                         用户信息控制层
 */
@Slf4j
@Api(tags = {"用户信息管理"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Qualifier("userService")
    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "查询用户信息", httpMethod = "GET", notes = "查询所有用户信息")
    @GetMapping
    public ResponseObject<List<UserVO>> find() {
        return ResponseResult.success(userService.findAll());
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "PUT", notes = "新增用户信息")
    @PutMapping
    public ResponseObject<UserVO> find(@ApiParam UserDTO studentDTO) {
        return ResponseResult.success(userService.save(studentDTO));
    }

    @ApiOperation(value = "根据用户ID查询用户信息", httpMethod = "GET", notes = "根据用户ID查询用户信息")
    @GetMapping("/{id}")
    public ResponseObject<UserVO> findUserById(
            @ApiParam(name = "id", value = "用户ID", required = true, example = "1269912454821879810")
            @Validated @PathVariable(name = "id") String id
    ) {
        return ResponseResult.success(userService.findUserById(id));
    }

}
