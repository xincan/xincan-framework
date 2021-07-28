package cn.com.xincan.xincanframework.server.idempotent.controller;

import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.plugins.anno.Idempotent;
import cn.com.xincan.xincanframework.plugins.service.IdempotentService;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import cn.com.xincan.xincanframework.utils.response.ResponseResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 幂等性配置
 * @author JiangXincan
 * @create 2021/7/27 15:57
 * @version 2.0.0
 */
@Api(tags = {"幂等性管理"})
@RestController
@RequestMapping("/idempotent")
@Validated
@ResponseResultBody
public class IdempotentController {

    @Qualifier("userService")
    private final IUserService userService;

    private final IdempotentService idempotentService;

    public IdempotentController(
            IUserService userService
            , IdempotentService idempotentService
    ){
        this.userService = userService;
        this.idempotentService = idempotentService;
    }


    @ApiOperation(value = "获取幂等性ID", httpMethod = "GET", notes = "获取幂等性ID")
    @GetMapping
    public ResponseObject<String> getToken() {
        String token = idempotentService.createToken();
        return ResponseResult.success(1, token);
    }


    @Idempotent
    @ApiOperation(value = "幂等性新增用户信息", httpMethod = "PUT", notes = "幂等性新增用户信息")
    @PutMapping
    public ResponseObject<UserSearchVo> save(@ApiParam @Validated UserSaveDto userSaveDto) {
        //return ResponseResult.success(1, userService.save(userSaveDto));
        return null;
    }

}
