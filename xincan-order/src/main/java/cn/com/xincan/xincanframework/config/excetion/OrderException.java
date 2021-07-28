package cn.com.xincan.xincanframework.config.excetion;

import cn.com.xincan.xincanframework.config.exception.BusinessException;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 自定义用户异常
 * @create 2020/9/14 18:25
 */
public class OrderException extends BusinessException {

    public OrderException() {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), ResponseCode.BUSINESS_EXCEPTION.message());
    }

    public OrderException(String msg) {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), msg);
    }

    public OrderException(int code, String msg) {
        super(code, msg);
    }

    public OrderException(ResponseCode responseCode, String msg) {
        this(responseCode.code(), msg);
    }

}
