package cn.com.xincan.xincanframework.server.sms;

import cn.com.xincan.xincanframework.plugins.entity.Email;
import cn.com.xincan.xincanframework.plugins.entity.Sms;
import cn.com.xincan.xincanframework.plugins.service.EmailService;
import cn.com.xincan.xincanframework.plugins.service.SmsService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 创建邮箱控制层
 * @create 2020/11/10 18:11
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/11/10 18:11             1.0                         创建邮箱控制层
 */
@RefreshScope
@RestController
@RequestMapping("global")
public class SmsController {

    private final EmailService emailService;

    private final SmsService smsService;

    public SmsController(
            EmailService emailService
            , SmsService smsService
    ) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @GetMapping("email")
    public Email sendEmail() {
        return emailService.send();
    }

    @GetMapping("sms")
    public Sms sendSms() {
        return smsService.send();
    }

}
