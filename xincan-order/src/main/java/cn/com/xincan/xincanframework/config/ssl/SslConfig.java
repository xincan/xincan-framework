package cn.com.xincan.xincanframework.config.ssl;

import io.undertow.UndertowOptions;
import io.undertow.servlet.api.SecurityConstraint;
import io.undertow.servlet.api.SecurityInfo;
import io.undertow.servlet.api.TransportGuaranteeType;
import io.undertow.servlet.api.WebResourceCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/10/10 15:26             1.0                         采用Undertow作为服务器,支持Https服务配置
 * @program xincan-framework
 * @description 采用Undertow作为服务器,支持Https服务配置
 * @create 2020/10/10 15:26
 */
@Configuration
public class SslConfig {

    @Value("${server.port}")
    private Integer serverPort;


    /**
     *  采用Undertow作为服务器。
     * Undertow是一个用java编写的、灵活的、高性能的Web服务器，提供基于NIO的阻塞和非阻塞API，特点：
     * 非常轻量级，Undertow核心瓶子在1Mb以下。它在运行时也是轻量级的，有一个简单的嵌入式服务器使用少于4Mb的堆空间。
     * 支持HTTP升级，允许多个协议通过HTTP端口进行多路复用。
     * 提供对Web套接字的全面支持，包括JSR-356支持。
     * 提供对Servlet 3.1的支持，包括对嵌入式servlet的支持。还可以在同一部署中混合Servlet和本机Undertow非阻塞处理程序。
     * 可以嵌入在应用程序中或独立运行，只需几行代码。
     * 通过将处理程序链接在一起来配置Undertow服务器。它可以对各种功能进行配置，方便灵活。
     * @author JiangXincan
     * @date 2020/10/23 10:13
     * @return org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
     */
    @Bean
    public UndertowServletWebServerFactory undertowServletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        // 这段就可以可以转换为http2
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_HTTP2, true));
        //这段可以增加http重定向，如果只需要http2的话下面的代码可以去掉
//        factory.addBuilderCustomizers(builder -> builder.addHttpListener(8000, "0.0.0.0"));

        //下面这段是将http的8000端口重定向到https的8000端口上
        factory.addDeploymentInfoCustomizers(deploymentInfo -> deploymentInfo.addSecurityConstraint(new SecurityConstraint()
                .addWebResourceCollection(new WebResourceCollection()
                .addUrlPattern("/*"))
                .setTransportGuaranteeType(TransportGuaranteeType.CONFIDENTIAL)
                .setEmptyRoleSemantic(SecurityInfo.EmptyRoleSemantic.PERMIT))
                .setConfidentialPortManager(exchange -> serverPort));
        return factory;
    }
}
