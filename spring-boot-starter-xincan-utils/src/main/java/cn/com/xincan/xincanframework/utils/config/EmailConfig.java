package cn.com.xincan.xincanframework.utils.config;

import cn.com.xincan.xincanframework.utils.properties.XincanProperties;
import cn.com.xincan.xincanframework.utils.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 工具包配置类
 * @create 2020/7/20 15:50
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/20 15:50             1.0                         工具包配置类
 */
@Configuration
@EnableConfigurationProperties(XincanProperties.class)
@ConditionalOnClass(EmailService.class)
@ConditionalOnProperty(prefix = "xincan", name = "enabled", havingValue = "true", matchIfMissing = true)
public class EmailConfig {

    private final XincanProperties xincanProperties;

    @Autowired
    public EmailConfig(XincanProperties xincanProperties) {
        this.xincanProperties = xincanProperties;
    }

    @Bean("emailService")
    @ConditionalOnMissingBean(name = "emailService")
    @ConditionalOnProperty(prefix = "xincan", name = "email.enabled", havingValue = "true", matchIfMissing = true)
    public EmailService emailService() {
        return new EmailService(xincanProperties.getEmail());
    }

}
