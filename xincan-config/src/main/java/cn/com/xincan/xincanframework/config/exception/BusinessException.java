package cn.com.xincan.xincanframework.config.exception;

import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import lombok.Getter;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description Restful请求API异常处理类
 * @create 2020/9/8 20:41
 */
@Getter
public class BusinessException extends RuntimeException {

    private int code;

    private String msg;

    public BusinessException() {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), ResponseCode.BUSINESS_EXCEPTION.message());
    }

    public BusinessException(String msg) {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), msg);
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ResponseCode responseCode, String msg) {
        this(responseCode.code(), msg);
        this.code = responseCode.code();
        this.msg = msg;
    }

}
