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
 * @author Jiangxincan
 * @version 0.0.1
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/5/26 12:17             0.0.1                         nacos测试
 * @program xincan-framework
 * @description 邮件管理控制层
 * @create 2020/5/26 12:17
 */
@Api(tags = {"邮件管理"})
@RestController
@RequestMapping("/email")
@RefreshScope
public class EmailController {


    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @ApiOperation(value = "查询邮件配置信息", httpMethod = "GET", notes = "查询邮件配置信息")
    @GetMapping
    public ResponseObject<Email> find() {
        Email emailProperty = emailService.email();
        return ResponseResult.success(emailProperty);
    }
}
