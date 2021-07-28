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
 */
public class EmailService extends GlobalService<Email> {

    private Email email;

    public EmailService(Email email) {
        this.email = email;
    }

    @Override
    public Email send(String message) {
        System.out.println("给"+email.getAddress()+"发送邮件，密码是："+ email.getPassword() + "邮件内容为：" + message);
        return email;
   }

}
