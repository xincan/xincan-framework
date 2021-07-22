package cn.com.xincan.xincanframework.config.swagger;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 接口转发问题配置
 * @create 2020/11/12 16:52
 */
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {

    public static final String HEADER_NAME = "X-Forwarded-Prefix";

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if(!StringUtils.endsWithIgnoreCase(path, SwaggerResourceConfig.API_URI)) {
                return chain.filter(exchange);
            }
            String basePath = path.substring(0, path.lastIndexOf(SwaggerResourceConfig.API_URI));
            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}
