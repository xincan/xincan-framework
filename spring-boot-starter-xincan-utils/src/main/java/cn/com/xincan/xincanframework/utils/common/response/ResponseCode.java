package cn.com.xincan.xincanframework.utils.common.response;

/**
 * Copyright (C), 2019, 心灿基础架构
 *
 * @program hatech-framework
 *  响应状态枚举类
 * @author JiangXincan
 * @date 2019/12/18 9:43
 * @version 0.0.1
 * <Author>                <Time>                  <Version>                   <Description>
 * JiangXincan         2019/12/18 9:43             0.0.1                         响应状态枚举类
 * JiangXincan              2019/12/20 9:38             0.0.1                         Http状态码
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

    REQUEST_FORBIDDEN(202, "请求拒绝"),
    REQUEST_NOT_FOUND(203, "请求未找到"),
    REQUEST_BAD(204, "错误的请求"),
    REQUEST_INVALID(205, "无效的请求"),
    REQUEST_TIMEOUT(206, "请求超时"),

    UNAUTHORIZED(401, "未授权"),
    UNAUTHORIZED_TOKEN(402, "TOKEN超时"),
    FORBIDDEN(403, "拒绝访问"),

    EXCEPTION(500, "服务器内部错误"),
    PARAM_ERROR(501, "参数错误"),
    BUSINESS_ERROR(502, "业务异常"),
    RPC_ERROR(503, "远程接口调用异常"),


    USER_NOT_EXIST(600, "用户不存在"),
    INCORRECT_USER_PASSWORD(601, "用户密码错误"),
    UNAUTHORIZED_CLIENT(602, "客户端未认证"),
    INVALID_CLIENT(603, "无效的客户端"),
    INVALID_GRANT(604, "无效的授权"),
    UNSUPPORTED_GRANT_TYPE(605, "不支持的授权类型"),
    INVALID_TOKEN(606, "无效的token"),
    INVALID_CLIENT_TOKEN(608, "客户端client和refresh_token不匹配"),
    INVALID_REFRESH_TOKEN(609, "无效的refresh token"),

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
