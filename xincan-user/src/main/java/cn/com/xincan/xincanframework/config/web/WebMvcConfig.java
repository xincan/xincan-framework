package cn.com.xincan.xincanframework.config.web;

import cn.com.xincan.xincanframework.plugins.intercepor.IdempotentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * 配置 spring mvc
 * @author Jiangxincan
 * @create 2019/12/23 15:13
 * @version 2.0.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加资源
     * @param registry 静态资源注册信息
     * @author Jiangxincan
     * @date 2020/1/7 10:28
     * @return void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 允许swagger-ui静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/service-worker.js").addResourceLocations("classpath:/META-INF/resources/service-worker.js");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/favicon.ico");
        registry.addResourceHandler("/precache-manifest.eea302037a9c2783bdf341d6c2dd2ca2.js").addResourceLocations("classpath:/META-INF/resources//precache-manifest.eea302037a9c2783bdf341d6c2dd2ca2.js");
    }

}
