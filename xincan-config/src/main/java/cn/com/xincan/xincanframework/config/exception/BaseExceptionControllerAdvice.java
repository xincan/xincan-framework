package cn.com.xincan.xincanframework.config.exception;

import cn.com.xincan.xincanframework.utils.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description 全局异常处理类
 * @create 2020/9/3 16:44
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionControllerAdvice implements ResponseBodyAdvice<Object> {


    /**类型不匹配*/
    private static final String TYPE_MISMATCH = "typeMismatch";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> clazz) {
        // 获取controller方法上是否有ResponseNotPackResultBody不需要结果包装类，如果有，直接返回body体，不进行包装
        boolean flag = Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(ResponseNotPackResultBody.class);
        if (flag) {
            return false;
        }
        // 获取当前函数所属controller上是否有ResponseResultBody
        boolean classFlag = Objects.requireNonNull(methodParameter.getMethod()).getDeclaringClass().isAnnotationPresent(ResponseResultBody.class);
        // 获取当前函数上是否有ResponseResultBody
        boolean methodFlag = methodParameter.getMethod().isAnnotationPresent(ResponseResultBody.class);
        return classFlag || methodFlag;
    }

    /**
     * 包装控制层controller统一返回值
     * @param body 消息体
      * @param methodParameter  方法参数列表
      * @param mediaType  请求类型
      * @param clazz  请求类
      * @param request  请求对象
      * @param response 返回对象
     * @author JiangXincan
     * @date 2021/7/20 11:57
     * @return java.lang.Object
     **/
    @Override
    public Object beforeBodyWrite(
            Object body,
            @Nullable MethodParameter methodParameter,
            @Nullable MediaType mediaType,
            @Nullable Class<? extends HttpMessageConverter<?>> clazz,
            @Nullable ServerHttpRequest request,
            @Nullable ServerHttpResponse response
    ) {

        // 如果控制层controller内部的函数是经过ResponseResult包装，并且返回值为ResponseObject，则不用转换，直接返回
        if(!ObjectUtils.isEmpty(body) && body instanceof ResponseObject) {
            return body;
        }

        // 否则要经过ResponseResult进行包装
        return ResponseResult.success(body);
    }

    /**
     *  自定义业务异常
     * @param businessException 业务异常类
     * @author Jiangxincan
     * @date 2020/9/9 14:37
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseObject<String> handlerBusinessException(BusinessException businessException) {
        log(BusinessException.class, ResponseCode.BUSINESS_EXCEPTION, businessException);
        return ResponseResult.error(ResponseCode.BUSINESS_EXCEPTION,  businessException.getMsg());
    }
    /**
     * 捕获 404 异常处理
     * @param noHandlerFoundException 404 异常
     * @author Jiangxincan
     * @date 2019/9/14 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseObject<String> handlerNoHandlerFoundException(NoHandlerFoundException noHandlerFoundException) {
        log(NoHandlerFoundException.class, ResponseCode.NOT_FOUND, noHandlerFoundException);
        return ResponseResult.error(ResponseCode.NOT_FOUND, "["+noHandlerFoundException.getHttpMethod()+"][" + noHandlerFoundException.getRequestURL() + "]请求，路径不存在");
    }

    /**
     * 捕获 202 异常处理
     * @param undeclaredThrowableException 202 请求频繁
     * @author Jiangxincan
     * @date 2019/9/14 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */

    @ExceptionHandler(value = UndeclaredThrowableException.class)
    public ResponseObject<String> undeclaredThrowableException(UndeclaredThrowableException undeclaredThrowableException) {
        log(UndeclaredThrowableException.class, ResponseCode.REQUEST_SERVICE_ERROR, undeclaredThrowableException);
        return ResponseResult.error(ResponseCode.REQUEST_SERVICE_ERROR);
    }

    /**
     * 捕获 405 异常处理
     * @param httpRequestMethodNotSupportedException 405 异常
     * @author Jiangxincan
     * @date 2019/9/14 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseObject<String> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException) {
        log(HttpRequestMethodNotSupportedException.class, ResponseCode.METHOD_NOT_ALLOWED, httpRequestMethodNotSupportedException);
        return ResponseResult.error(ResponseCode.METHOD_NOT_ALLOWED);
    }

    /**
     * 捕获 415 异常处理
     * @param httpMediaTypeNotSupportedException HttpMediaTypeNotSupportedException 415 异常
     * @author Jiangxincan
     * @date 2019/9/14 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseObject<String> handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException httpMediaTypeNotSupportedException) {
        log(HttpMediaTypeNotSupportedException.class, ResponseCode.UNSUPPORTED_MEDIA_TYPE, httpMediaTypeNotSupportedException);
        return ResponseResult.error(ResponseCode.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * 捕获 407 请求异常处理（controller之前发生的异常）
     * @param exception Exception 407 异常
     * @author Jiangxincan
     * @date 2019/09/09 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler({
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public ResponseObject<String> handleServletException(Exception exception) {
        Throwable throwable = exception.getCause();
        log(Exception.class, ResponseCode.REQUEST_EXCEPTION, throwable);
        return ResponseResult.error(ResponseCode.REQUEST_EXCEPTION);
    }

    /**
     * 捕获 500 异常处理
     * @param exception Exception 500 异常
     * @author Jiangxincan
     * @date 2019/09/09 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler({Exception.class})
    public ResponseObject<String> handlerException(Exception exception) {
        log(Exception.class, ResponseCode.EXCEPTION, exception);
        return ResponseResult.error(ResponseCode.EXCEPTION, "请联系后台开发人员," + exception.toString());
    }

    /**
     *  捕获controller层函数单个参数校验异常
     * @param constraintViolationException 参数校验异常
     * @author Jiangxincan
     * @date 2020/9/8 20:38
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseObject<String> handlerConstraintViolationException(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        if (constraintViolations.isEmpty()) {
            log.error("ConstraintViolationException校验器为空");
            log(Exception.class, ResponseCode.PARAM_EXCEPTION, constraintViolationException.getCause());
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION.code(), "ConstraintViolationException校验器为空");
        }
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        ConstraintViolation<?> constraintViolation = iterator.next();
        log.error("[{}], from object [{}] in params, this property [{}]=[{}]", constraintViolation.getMessage(), constraintViolation.getRootBeanClass().getName(), constraintViolation.getPropertyPath(), constraintViolation.getInvalidValue());
        return ResponseResult.error(ResponseCode.PARAM_EXCEPTION,  constraintViolation.getMessageTemplate());
    }

    /**
     *  参数异常校验处理
     *  （@RequestBody）
     * @param methodArgumentNotValidException 参数异常处理类
     * @author Jiangxincan
     * @date 2020/9/3 16:46
     * @return java.lang.String
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseObject<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        return paramValidException(fieldErrors);
    }

    /**
     *  参数异常校验处理
     *  （非@RequestBody）
     * @param exception BindException 属性校验异常
     * @author Jiangxincan
     * @date 2020/9/4 11:15
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(BindException.class)
    public ResponseObject<String> handlerBindException(BindException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return paramValidException(fieldErrors);
    }

    /**
     *  统一处理异常信息
     * @param  fieldErrors 异常信息列表
     * @author Jiangxincan
     * @date 2020/9/7 14:59
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    private ResponseObject<String> paramValidException(List<FieldError> fieldErrors) {
        if (fieldErrors.isEmpty()) {
            log.error("校验错误fieldErrors为空");
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION);
        }
        FieldError fieldError = fieldErrors.get(0);
        log.error("[{}], from object [{}] in params, this property [{}]=[{}]", fieldError.getDefaultMessage(), fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue());
        if (TYPE_MISMATCH.equals(fieldError.getCode())) {
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION, fieldError.getField() + "属性，格式错误");
        }
        return ResponseResult.error(ResponseCode.PARAM_EXCEPTION,  fieldError.getDefaultMessage());
    }


    /**
     *  错误日志打印
     * @param errorType          错误类型
     * @param secondaryErrorType 二次错误类型
     * @param throwable          错误信息
     * @author Jiangxincan
     * @date 2020/9/4 10:16
     * @return void
     */
    public void log(@NotNull Class<?> errorType, Enum<?> secondaryErrorType, Throwable throwable) {
        ResponseCode responseCode = (ResponseCode)secondaryErrorType;
        log.error("[{}] [{}] [{}]", errorType.getSimpleName(), responseCode.message(), throwable.getMessage(), throwable);
    }

    /**
     *  错误日志打印
     * @param errorType          错误类型
     * @param secondaryErrorType 二次错误类型
     * @param exception          错误信息
     * @author Jiangxincan
     * @date 2020/9/4 10:16
     * @return void
     */
    public void log(@NotNull Class<?> errorType, Enum<?> secondaryErrorType, Exception exception) {
        ResponseCode responseCode = (ResponseCode)secondaryErrorType;
        log.error("[{}] [{}] [{}]", errorType.getSimpleName(), responseCode.message(), exception.toString(), exception);
    }

}
