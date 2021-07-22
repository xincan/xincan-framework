package cn.com.xincan.xincanframework.config.ssl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 将https请求修改成http请求，后台微服务部署在内网，无需开启http请求，由于网关需要https请求，所以在此拦截，调用后台时进行转换
 * @create 2020/11/12 16:11
 */
@Slf4j
@Component
public class HttpsToHttpFilter implements GlobalFilter, Ordered {

    public static final int HTTPS_TO_HTTP_FILTER_ORDER_BEFORE = 10099;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI originalUri = exchange.getRequest().getURI();
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        String forwardedUri = request.getURI().toString();
        if (forwardedUri != null && forwardedUri.startsWith("https")) {
            try {
                URI mutatedUri = new URI("http",
                        originalUri.getUserInfo(),
                        originalUri.getHost(),
                        originalUri.getPort(),
                        originalUri.getPath(),
                        originalUri.getQuery(),
                        originalUri.getFragment()
                );
                mutate.uri(mutatedUri);
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        ServerHttpRequest build = mutate.build();
        log.info("{}：{}", "HTTPS转换成HTTP地址为", exchange.mutate().request(build).build().getRequest().getURI());
        return chain.filter(exchange.mutate().request(build).build());
    }

    @Override
    public int getOrder() {
        return HTTPS_TO_HTTP_FILTER_ORDER_BEFORE;
    }
}
