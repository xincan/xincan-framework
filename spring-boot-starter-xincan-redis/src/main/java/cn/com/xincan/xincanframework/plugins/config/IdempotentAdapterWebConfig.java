package cn.com.xincan.xincanframework.plugins.config;

import cn.com.xincan.xincanframework.plugins.intercepor.IdempotentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
public class IdempotentAdapterWebConfig implements WebMvcConfigurer {


    private final IdempotentInterceptor idempotentInterceptor;

    public IdempotentAdapterWebConfig(IdempotentInterceptor idempotentInterceptor) {
        this.idempotentInterceptor = idempotentInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(idempotentInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
