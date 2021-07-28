package cn.com.xincan.xincanframework.plugins.intercepor;

import cn.com.xincan.xincanframework.plugins.anno.Idempotent;
import cn.com.xincan.xincanframework.plugins.service.IdempotentService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 自定义幂等性拦截器
 * @author JiangXincan
 * @create 2021/7/27 14:31
 * @version 2.0.0
 */
@Component
public class IdempotentInterceptor implements HandlerInterceptor {


    private final IdempotentService idempotentService;

    public IdempotentInterceptor(IdempotentService idempotentService) {
        this.idempotentService = idempotentService;
    }

    /**
     * 预处理
     * @param request  请求体
      * @param response  返回体
      * @param handler 头部信息
     * @author JiangXincan
     * @date 2021/7/27 14:37
     * @return boolean
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //被Idempotent标记的扫描
        Idempotent methodAnnotation = method.getAnnotation(Idempotent.class);
        if (methodAnnotation != null) {
            // 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
            return idempotentService.checkToken(request);
        }
        //必须返回true,否则会被拦截一切请求
        return true;
    }
}
