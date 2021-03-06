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
 * copyright (C), 2020, ??????????????????????????????????????????
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description ?????????????????????
 * @create 2020/9/3 16:44
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionControllerAdvice implements ResponseBodyAdvice<Object> {


    /**???????????????*/
    private static final String TYPE_MISMATCH = "typeMismatch";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> clazz) {
        // ??????controller??????????????????ResponseNotPackResultBody???????????????????????????????????????????????????body?????????????????????
        boolean flag = Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(ResponseNotPackResultBody.class);
        if (flag) {
            return false;
        }
        // ????????????????????????controller????????????ResponseResultBody
        boolean classFlag = Objects.requireNonNull(methodParameter.getMethod()).getDeclaringClass().isAnnotationPresent(ResponseResultBody.class);
        // ??????????????????????????????ResponseResultBody
        boolean methodFlag = methodParameter.getMethod().isAnnotationPresent(ResponseResultBody.class);
        return classFlag || methodFlag;
    }

    /**
     * ???????????????controller???????????????
     * @param body ?????????
      * @param methodParameter  ??????????????????
      * @param mediaType  ????????????
      * @param clazz  ?????????
      * @param request  ????????????
      * @param response ????????????
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

        // ???????????????controller????????????????????????ResponseResult???????????????????????????ResponseObject?????????????????????????????????
        if(!ObjectUtils.isEmpty(body) && body instanceof ResponseObject) {
            return body;
        }

        // ???????????????ResponseResult????????????
        return ResponseResult.success(body);
    }

    /**
     *  ?????????????????????
     * @param businessException ???????????????
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
     * ?????? 404 ????????????
     * @param noHandlerFoundException 404 ??????
     * @author Jiangxincan
     * @date 2019/9/14 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseObject<String> handlerNoHandlerFoundException(NoHandlerFoundException noHandlerFoundException) {
        log(NoHandlerFoundException.class, ResponseCode.NOT_FOUND, noHandlerFoundException);
        return ResponseResult.error(ResponseCode.NOT_FOUND, "["+noHandlerFoundException.getHttpMethod()+"][" + noHandlerFoundException.getRequestURL() + "]????????????????????????");
    }

    /**
     * ?????? 202 ????????????
     * @param undeclaredThrowableException 202 ????????????
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
     * ?????? 405 ????????????
     * @param httpRequestMethodNotSupportedException 405 ??????
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
     * ?????? 415 ????????????
     * @param httpMediaTypeNotSupportedException HttpMediaTypeNotSupportedException 415 ??????
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
     * ?????? 407 ?????????????????????controller????????????????????????
     * @param exception Exception 407 ??????
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
     * ?????? 500 ????????????
     * @param exception Exception 500 ??????
     * @author Jiangxincan
     * @date 2019/09/09 16:21
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler({Exception.class})
    public ResponseObject<String> handlerException(Exception exception) {
        log(Exception.class, ResponseCode.EXCEPTION, exception);
        return ResponseResult.error(ResponseCode.EXCEPTION, "???????????????????????????," + exception.toString());
    }

    /**
     *  ??????controller?????????????????????????????????
     * @param constraintViolationException ??????????????????
     * @author Jiangxincan
     * @date 2020/9/8 20:38
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseObject<String> handlerConstraintViolationException(ConstraintViolationException constraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
        if (constraintViolations.isEmpty()) {
            log.error("ConstraintViolationException???????????????");
            log(Exception.class, ResponseCode.PARAM_EXCEPTION, constraintViolationException.getCause());
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION.code(), "ConstraintViolationException???????????????");
        }
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        ConstraintViolation<?> constraintViolation = iterator.next();
        log.error("[{}], from object [{}] in params, this property [{}]=[{}]", constraintViolation.getMessage(), constraintViolation.getRootBeanClass().getName(), constraintViolation.getPropertyPath(), constraintViolation.getInvalidValue());
        return ResponseResult.error(ResponseCode.PARAM_EXCEPTION,  constraintViolation.getMessageTemplate());
    }

    /**
     *  ????????????????????????
     *  ???@RequestBody???
     * @param methodArgumentNotValidException ?????????????????????
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
     *  ????????????????????????
     *  ??????@RequestBody???
     * @param exception BindException ??????????????????
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
     *  ????????????????????????
     * @param  fieldErrors ??????????????????
     * @author Jiangxincan
     * @date 2020/9/7 14:59
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    private ResponseObject<String> paramValidException(List<FieldError> fieldErrors) {
        if (fieldErrors.isEmpty()) {
            log.error("????????????fieldErrors??????");
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION);
        }
        FieldError fieldError = fieldErrors.get(0);
        log.error("[{}], from object [{}] in params, this property [{}]=[{}]", fieldError.getDefaultMessage(), fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue());
        if (TYPE_MISMATCH.equals(fieldError.getCode())) {
            return ResponseResult.error(ResponseCode.PARAM_EXCEPTION, fieldError.getField() + "?????????????????????");
        }
        return ResponseResult.error(ResponseCode.PARAM_EXCEPTION,  fieldError.getDefaultMessage());
    }


    /**
     *  ??????????????????
     * @param errorType          ????????????
     * @param secondaryErrorType ??????????????????
     * @param throwable          ????????????
     * @author Jiangxincan
     * @date 2020/9/4 10:16
     * @return void
     */
    public void log(@NotNull Class<?> errorType, Enum<?> secondaryErrorType, Throwable throwable) {
        ResponseCode responseCode = (ResponseCode)secondaryErrorType;
        log.error("[{}] [{}] [{}]", errorType.getSimpleName(), responseCode.message(), throwable.getMessage(), throwable);
    }

    /**
     *  ??????????????????
     * @param errorType          ????????????
     * @param secondaryErrorType ??????????????????
     * @param exception          ????????????
     * @author Jiangxincan
     * @date 2020/9/4 10:16
     * @return void
     */
    public void log(@NotNull Class<?> errorType, Enum<?> secondaryErrorType, Exception exception) {
        ResponseCode responseCode = (ResponseCode)secondaryErrorType;
        log.error("[{}] [{}] [{}]", errorType.getSimpleName(), responseCode.message(), exception.toString(), exception);
    }

}
