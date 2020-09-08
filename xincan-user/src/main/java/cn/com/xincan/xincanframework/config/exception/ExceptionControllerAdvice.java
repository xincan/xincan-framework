package cn.com.xincan.xincanframework.config.exception;

import cn.com.xincan.xincanframework.utils.common.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.common.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 全局异常处理类
 * @create 2020/9/3 16:44
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/3 16:44             1.0                         全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**类型不匹配*/
    private static final String TYPE_MISMATCH = "typeMismatch";

    /**
     *  参数异常校验处理
     *  （@RequestBody）
     * @param methodArgumentNotValidException 参数异常处理类
     * @author JiangXincan
     * @date 2020/9/3 16:46
     * @return java.lang.String
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseObject<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        return paramValidException(fieldErrors);
    }

    /**
     *  参数异常校验处理
     *  （非@RequestBody）
     * @param exception BindException 属性校验异常
     * @author JiangXincan
     * @date 2020/9/4 11:15
     * @return cn.com.xincan.xincanframework.utils.common.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(BindException.class)
    public ResponseObject<String> bindException(BindException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return paramValidException(fieldErrors);
    }

    /**
     *  统一处理异常信息
     * @param  fieldErrors 异常信息列表
     * @author JiangXincan
     * @date 2020/9/7 14:59
     * @return cn.com.xincan.xincanframework.utils.common.response.ResponseObject<java.lang.String>
     */
    private ResponseObject<String> paramValidException(List<FieldError> fieldErrors) {
        if (fieldErrors.isEmpty()) {
            log.error("validExceptionHandler 错误 fieldErrors 为空");
            ResponseResult.error(ResponseCode.BUSINESS_ERROR);
        }
        FieldError fieldError = fieldErrors.get(0);
        log.info("[{}], from object [{}] in params, this property [{}]=[{}]", fieldError.getDefaultMessage(), fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue());
        if (TYPE_MISMATCH.equals(fieldError.getCode())) {
            return ResponseResult.error(ResponseCode.PARAM_ERROR, fieldError.getField() + "属性，格式错误");
        }
        return ResponseResult.error(ResponseCode.PARAM_ERROR,  fieldError.getDefaultMessage());
    }





    /**
     *  错误日志打印
     * @param errorType          错误类型
     * @param secondaryErrorType 二次错误类型
     * @param throwable          错误信息
     * @author JiangXincan
     * @date 2020/9/4 10:16
     * @return void
     */
    private void log(@NotNull Class errorType, Enum secondaryErrorType, Throwable throwable) {
        log.error("[{}] [{}] : [{}]", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage(),
                throwable);
    }

}
