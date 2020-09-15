package cn.com.xincan.xincanframework.utils.service;

import cn.com.xincan.xincanframework.utils.entity.Email;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/20 15:56             0.0.1                         配置服务实现类
 * @program xincan-framework
 * @description 配置服务接口类
 * @create 2020/7/20 15:56
 */
public class EmailService {

    private Email email;

    public EmailService(Email email) {
        this.email = email;
    }

    public Email email() {

        System.out.println("=======进入自定义starter方法======");

       return email;
   }

}
