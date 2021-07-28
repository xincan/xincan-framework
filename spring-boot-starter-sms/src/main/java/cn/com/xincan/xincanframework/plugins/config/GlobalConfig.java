package cn.com.xincan.xincanframework.plugins.config;

import cn.com.xincan.xincanframework.plugins.properties.GlobalProperties;
import cn.com.xincan.xincanframework.plugins.service.EmailService;
import cn.com.xincan.xincanframework.plugins.service.SmsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 工具包配置类
 * @create 2020/7/20 15:50
 */
@Configuration
@EnableConfigurationProperties(GlobalProperties.class)
@ConditionalOnProperty(prefix = GlobalProperties.GLOBAL_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class GlobalConfig {

    private final GlobalProperties globalProperties;

    public GlobalConfig(GlobalProperties globalProperties) {
        this.globalProperties = globalProperties;
    }

    @Bean("emailService")
    @ConditionalOnMissingBean(name = "emailService")
    @ConditionalOnProperty(prefix = GlobalProperties.GLOBAL_PREFIX, name = "email.enabled", havingValue = "true", matchIfMissing = true)
    public EmailService emailService() {
        return new EmailService(globalProperties.getEmail());
    }

    @Bean("smsService")
    @ConditionalOnMissingBean(name = "smsService")
    @ConditionalOnProperty(prefix = GlobalProperties.GLOBAL_PREFIX, name = "sms.enabled", havingValue = "true", matchIfMissing = true)
    public SmsService smsService() {
        return new SmsService(globalProperties.getSms());
    }

}
