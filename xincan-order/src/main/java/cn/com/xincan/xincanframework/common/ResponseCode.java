package cn.com.xincan.xincanframework.common;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 *  响应状态枚举类
 * @author JiangXincan
 * @date 2019/12/18 9:43
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * JiangXincan         2019/12/18 9:43             1.0                         响应状态枚举类
 * YeMeng              2019/12/20 9:38             1.0                         Http状态码
 */
public enum ResponseCode {

    /**
     * 请求成功
     */
    REQUEST_SUCCESS(200, "请求成功"),

    /**
     * 请求失败
     */
    REQUEST_ERROR(201, "请求失败"),

    ;

    /**
     * 状态码
      */
    private final Integer code;

    /**
     * 状态解释
     */
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     *  返回状态码的数值
     * @author YeMeng
     * @date 2020/1/8 19:45
     * @return int类型状态码
     */
    public int code() {
        return this.code;
    }

    /**
     *  返回状态码的解释
     * @author YeMeng
     * @date 2020/1/8 19:45
     * @return java.lang.String 状态解释
     */
    public String message() {
        return this.message;
    }

}
