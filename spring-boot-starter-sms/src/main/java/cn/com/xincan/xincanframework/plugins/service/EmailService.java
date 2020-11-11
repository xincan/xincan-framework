package cn.com.xincan.xincanframework.plugins.service;

import cn.com.xincan.xincanframework.plugins.entity.Email;
import cn.com.xincan.xincanframework.plugins.properties.GlobalProperties;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 邮件服务接口类
 * @create 2020/7/20 15:56
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/20 15:56             0.0.1                        邮件服务实现类
 */
public class EmailService {

    private Email email;

    public EmailService(Email email) {
        this.email = email;
    }

    public Email send() {
        System.out.println("给"+email.getAddress()+"发送邮件，密码是："+ email.getPassword());
        return email;
   }

}
