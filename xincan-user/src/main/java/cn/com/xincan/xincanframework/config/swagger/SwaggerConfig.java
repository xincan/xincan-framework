package cn.com.xincan.xincanframework.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * copyright (C), 2019, 心灿基础架构
 *
 * @program hatech-framework
 * Swagger API 配置
 * @author JiangXincan
 * @create 2019/12/23 16:09
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2019/12/23 16:09             1.0                         Sharing 数据源aop
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
                .version("1.0")
                .build();
    }

}
