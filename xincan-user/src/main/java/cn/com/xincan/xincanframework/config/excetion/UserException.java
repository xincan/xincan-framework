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
public class UserException extends BusinessException {

    public UserException() {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), ResponseCode.BUSINESS_EXCEPTION.message());
    }

    public UserException(String msg) {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), msg);
    }

    public UserException(int code, String msg) {
        super(code, msg);
    }

    public UserException(ResponseCode responseCode, String msg) {
        this(responseCode.code(), msg);
    }

}
