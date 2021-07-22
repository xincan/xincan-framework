package cn.com.xincan.xincanframework.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.*;

import java.util.Optional;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description Gateway聚合Swagger接口控制层
 * @create 2020/10/23 11:26
 */
@RestController
@RequestMapping("/swagger-resources")
public class SwaggerController {

    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

    @Autowired(required = false)
    private UiConfiguration uiConfiguration;

    private final SwaggerResourcesProvider swaggerResourcesProvider;

    public SwaggerController(SwaggerResourcesProvider swaggerResourcesProvider) {
        this.swaggerResourcesProvider = swaggerResourcesProvider;
    }

    @GetMapping
    public Mono<ResponseEntity> swaggerResources() {
        return Mono.just((new ResponseEntity<>(swaggerResourcesProvider.get(), HttpStatus.OK)));
    }

    @GetMapping("/configuration/security")
    public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

    @GetMapping("/configuration/ui")
    public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
        return Mono.just(new ResponseEntity<>(
                Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
    }

}
