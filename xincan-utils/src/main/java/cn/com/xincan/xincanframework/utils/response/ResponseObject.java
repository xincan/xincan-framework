package cn.com.xincan.xincanframework.utils.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 *  响应结果实体类
 * @author Jiangxincan
 * @date 2019/12/18 9:43
 * @version 0.0.1
 */
@ApiModel(description = "响应结果信息")
public class ResponseObject<T> {

    @ApiModelProperty(name = "code", dataType = "Integer", value = "响应结果编码")
    private Integer code;

    @ApiModelProperty(name = "msg", dataType = "String", value = "响应结果信息")
    private String msg;

    @ApiModelProperty(name = "count", dataType = "Long", value = "统计列表总数（如果列表存在）")
    private long count;

    @ApiModelProperty(name = "data", dataType = "Object", value = "响应结果数据")
    private T data;

    @ApiModelProperty(name = "time", dataType = "Long", value = "响应结果时间")
    private long time = System.currentTimeMillis();

    public ResponseObject() {}

    public ResponseObject(ResponseCode responseCode) {
        this.code = responseCode.code();
        this.msg = responseCode.message();
    }

    public ResponseObject(ResponseCode responseCode, long count, T data) {
        this.code = responseCode.code();
        this.msg = responseCode.message();
        this.count = count;
        this.data = data;
    }

    public ResponseObject<T> code(ResponseCode responseCode) {
        this.code = responseCode.code();
        this.msg = responseCode.message();
        return this;
    }

    public ResponseObject<T> code(int code) {
        this.code = code;
        return this;
    }


    public ResponseObject<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseObject<T> count(long count) {
        this.count = count;
        return this;
    }

    public ResponseObject<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResponseObject<T> time(long time) {
        this.time = time;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public long getCount() {
        return count;
    }

    public T getData() {
        return data;
    }

    public long getTime() {
        return time;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
