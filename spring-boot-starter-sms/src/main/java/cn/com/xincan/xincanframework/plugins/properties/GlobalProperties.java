package cn.com.xincan.xincanframework.plugins.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import cn.com.xincan.xincanframework.plugins.entity.Email;
import cn.com.xincan.xincanframework.plugins.entity.Sms;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 全局信息配置类
 * @create 2020/7/20 15:38
 */
@ConfigurationProperties(prefix = GlobalProperties.GLOBAL_PREFIX)
public class GlobalProperties {

    public static final String GLOBAL_PREFIX = "global";

    private boolean enabled;

    private Email email;

    private Sms sms;

    public GlobalProperties(Email email, Sms sms) {
        this.email = email;
        this.sms = sms;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Sms getSms() {
        return sms;
    }

    public void setSms(Sms sms) {
        this.sms = sms;
    }
}
