package cn.com.xincan.xincanframework.plugins.entity;

import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 短信配置信息实体类
 * @create 2020/7/20 15:44
 */
@Component
public class Sms {

    private boolean enabled;

    private String name;

    private String phone;

    private String idCard;

    public Sms() {}

    public Sms(boolean enabled, String name, String phone, String idCard) {
        this.enabled = enabled;
        this.name = name;
        this.phone = phone;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "enabled=" + enabled +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
