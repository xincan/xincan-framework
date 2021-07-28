package cn.com.xincan.xincanframework.plugins.entity;

import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 邮件配置信息实体类
 * @create 2020/7/20 15:44
 */
@Component
public class Email {

    private boolean enabled;

    private String address;

    private String password;

    public Email() {}

    public Email(String address, String password) {
        this.address = address;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
