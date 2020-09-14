package cn.com.xincan.xincanframework.excetion;

import cn.com.xincan.xincanframework.config.exception.BaseExceptionControllerAdvice;
import cn.com.xincan.xincanframework.config.exception.BusinessException;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 自定义异常处理
 * @create 2020/9/14 18:08
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/14 18:08             1.0                         自定义异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice extends BaseExceptionControllerAdvice {

    /**
     *  自定义业务异常
     * @param userException 业务异常类
     * @author Jiangxincan
     * @date 2020/9/9 14:37
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.lang.String>
     */
    @ExceptionHandler(UserException.class)
    public ResponseObject<String> handlerBusinessException(UserException userException) {
        log(UserException.class, ResponseCode.BUSINESS_EXCEPTION, userException);
        return ResponseResult.error(ResponseCode.BUSINESS_EXCEPTION,  userException.getMsg());
    }

}
