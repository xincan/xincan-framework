package cn.com.xincan.xincanframework.plugins.exception;

import cn.com.xincan.xincanframework.utils.response.ResponseCode;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description redis异常定义
 * @author JiangXincan
 * @create 2021/7/27 11:25
 * @version 2.0.0
 */
public class IdempotentException extends RuntimeException {

    private static final long serialVersionUID = -1025484526445626712L;

    private int code;

    private String msg;

    public IdempotentException(ResponseCode responseCode) {
        this(responseCode.code(), responseCode.message());
    }

    public IdempotentException(String msg) {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), msg);
    }

    public IdempotentException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public IdempotentException(ResponseCode responseCode, String msg) {
        this(responseCode.code(), msg);
        this.code = responseCode.code();
        this.msg = msg;
    }
}
