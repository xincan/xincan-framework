package cn.com.xincan.xincanframework.utils.common.response;

/**
 * Copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 *  响应状态枚举类
 * @author JiangXincan
 * @date 2019/12/18 9:43
 * @version 0.0.1
 * <Author>                <Time>                  <Version>                   <Description>
 * JiangXincan         2019/12/18 9:43             0.0.1                         响应状态枚举类
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
    EXCEPTION(500, "服务异常"),
    INTERFACE_ERROR(501, "接口异常"),
    PARAM_ERROR(502, "参数异常"),
    BUSINESS_ERROR(503, "业务异常")
    ;

    /**
     * 状态码
      */
    private final int code;

    /**
     * 状态解释
     */
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     *  返回状态码的数值
     * @author JiangXincan
     * @date 2020/1/8 19:45
     * @return Integer
     */
    public int code() {
        return this.code;
    }

    /**
     *  返回状态码的解释
     * @author JiangXincan
     * @date 2020/1/8 19:45
     * @return java.lang.String 状态解释
     */
    public String message() {
        return this.message;
    }

}
