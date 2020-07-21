package cn.com.xincan.xincanframework.server.nacos.controller;


import cn.com.xincan.xincanframework.utils.common.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.common.response.ResponseResult;
import cn.com.xincan.xincanframework.utils.entity.Email;
import cn.com.xincan.xincanframework.utils.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/5/26 12:17             1.0                         nacos测试
 * @program xincan-framework
 * @description nacos测试
 * @create 2020/5/26 12:17
 */
@Api(tags = {"Nacos管理"})
@RestController
@RequestMapping("/nacos")
@RefreshScope
public class XincanNacosController {


    private final EmailService emailService;

    @Autowired
    public XincanNacosController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ApiOperation(value = "查询Nacos配置信息", httpMethod = "GET", notes = "查询Nacos配置信息")
    @GetMapping("/info")
    public ResponseObject<Email> find() {
        Email emailProperty = emailService.email();
        return ResponseResult.success(emailProperty);
    }

}
