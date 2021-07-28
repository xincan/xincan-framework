package cn.com.xincan.xincanframework.config.excetion;

import cn.com.xincan.xincanframework.config.exception.BusinessException;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-goods
 * @description 自定义用户异常
 * @create 2020/9/14 18:25
 */
public class GoodsException extends BusinessException {

    public GoodsException() {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), ResponseCode.BUSINESS_EXCEPTION.message());
    }

    public GoodsException(String msg) {
        this(ResponseCode.BUSINESS_EXCEPTION.code(), msg);
    }

    public GoodsException(int code, String msg) {
        super(code, msg);
    }

    public GoodsException(ResponseCode responseCode, String msg) {
        this(responseCode.code(), msg);
    }

}
