package cn.com.xincan.xincanframework.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 * Swagger API 配置
 * @author Jiangxincan
 * @create 2019/12/23 16:09
 * @version 0.0.1
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@ConditionalOnProperty(value = {"true"}, matchIfMissing = true)
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(ZonedDateTime.class, String.class)
                .apiInfo(apiInfo())
                .groupName("默认接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.com.xincan.xincanframework.server"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName + " RESTFUL APIs")
                .description(applicationName + " RESTFUL APIs")
                .termsOfServiceUrl("http://www.github.com/xincan")
                .version("0.0.1")
                .build();
    }

}
