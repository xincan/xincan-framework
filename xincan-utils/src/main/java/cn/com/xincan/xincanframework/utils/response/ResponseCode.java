package cn.com.xincan.xincanframework.utils.response;

/**
 * Copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 *  响应状态枚举类
 * @author Jiangxincan
 * @date 2019/12/18 9:43
 * @version 0.0.1
 */
public enum ResponseCode {

    /**
     * 请求成功
     */
    REQUEST_SUCCESS(200, "操作成功"),
    REQUEST_ERROR(201, "操作失败"),
    REQUEST_SERVICE_ERROR(202, "服务请求频繁，请稍后重试"),

    NOT_FOUND(404, "无法找到资源"),
    METHOD_NOT_ALLOWED(405, "请求方法错误"),
    UNSUPPORTED_MEDIA_TYPE(406, "请求不支持该媒体类型"),
    REQUEST_EXCEPTION(407, "请求异常"),

    EXCEPTION(500, "服务异常"),
    INTERFACE_EXCEPTION(501, "接口异常"),
    PARAM_EXCEPTION(502, "参数异常"),
    BUSINESS_EXCEPTION(503, "业务异常"),
    RPC_ERROR(504, "远程调用异常"),

    IDEMPOTENT_EXISTS_EXCEPTION(601, "幂等性TOKEN不存在"),
    IDEMPOTENT_REPETITION_OPERATION_EXCEPTION(601, "重复性操作"),
    CHAOS_JIANGJI(700, "服务降级")
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
     * @author Jiangxincan
     * @date 2020/1/8 19:45
     * @return Integer
     */
    public int code() {
        return this.code;
    }

    /**
     *  返回状态码的解释
     * @author Jiangxincan
     * @date 2020/1/8 19:45
     * @return java.lang.String 状态解释
     */
    public String message() {
        return this.message;
    }

}
