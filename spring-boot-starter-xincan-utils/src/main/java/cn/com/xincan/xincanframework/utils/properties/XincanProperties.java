package cn.com.xincan.xincanframework.utils.properties;

import cn.com.xincan.xincanframework.utils.entity.Email;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/20 15:38             1.0                         Nacos配置信息
 * @program xincan-framework
 * @description Nacos配置信息
 * @create 2020/7/20 15:38
 */
@Component
@ConfigurationProperties(prefix = "xincan")
public class XincanProperties {


    private Email email;

    public XincanProperties(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
