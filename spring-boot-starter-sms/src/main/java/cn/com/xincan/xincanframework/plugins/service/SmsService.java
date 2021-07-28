package cn.com.xincan.xincanframework.plugins.service;

import cn.com.xincan.xincanframework.plugins.entity.Sms;
import cn.com.xincan.xincanframework.plugins.properties.GlobalProperties;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 短信服务接口类
 * @create 2020/7/20 15:56
 */
public class SmsService extends GlobalService<Sms>{

    private Sms sms;

    public SmsService(Sms sms) {
        this.sms = sms;
    }

    @Override
    public Sms send(String message) {
        System.out.println("给"+sms.getName()+"["+sms.getIdCard()+"]打电话，电话号码是："+ sms.getPhone()+"聊天内容为：" + message);
        return sms;
   }

}
