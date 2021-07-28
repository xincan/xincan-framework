package cn.com.xincan.xincanframework.utils.response;


/**
 * Copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 *  响应状态结果信息实体类
 * @author Jiangxincan
 * @date 2019/12/18 9:43
 * @version 0.0.1
 */
@SuppressWarnings("unchecked")
public class ResponseResult {

    private ResponseResult(){}

    /**
     *  返回处理结果
     *
     * 针对于返回业务处理之后，无需通知前端具体处理信息，走系统默认的提示信息
     *
     * @param <T> 响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success() {
        return new ResponseObject(ResponseCode.REQUEST_SUCCESS);
    }

    /**
     *  返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @param responseCode   响应状态
     * @param data           响应数据
     * @author Jiangxincan
     * @date 2019/12/20 14:41
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(ResponseCode responseCode, T data) {
        return new ResponseObject<T>(responseCode)
                .count(1)
                .data(data);
    }

    /**
     *  返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(T data) {
        return new ResponseObject<T>(ResponseCode.REQUEST_SUCCESS)
                .count(1)
                .data(data);
    }

    /**
     *  返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，并且将处理结果描述提供给前端
     *
     * @param message   响应结果描述
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(String message, T data) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_SUCCESS)
                .msg(message)
                .count(1)
                .data(data);
    }


    /**
     *  返回分页数据信息
     *
     * （数据分页）针对于返回业务处理之后，需要向前端反馈后台处理分页的数据，
     *  并携带状态、数据总条数、系统默认处理信息
     *
     * @param count     响应数据条数
     * @param data      响应数据
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(long count, T data){
        return new ResponseObject<T>(ResponseCode.REQUEST_SUCCESS)
                .count(count)
                .data(data);
    }

    /**
     *  返回分页数据信息
     *
     * （数据分页）针对于返回业务处理之后，需要向前端反馈后台处理分页的数据，
     *  并携带状态、数据总条数、自定义处理信息
     *
     * @param message   响应结果信息
     * @param count     响应数据条数
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(String message, long count, T data){
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_SUCCESS)
                .msg(message)
                .count(count)
                .data(data);
    }

    /**
     *  返回分页数据信息
     *
     * @param code      响应结果编码
     * @param message   响应结果信息
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(int code, String message, T data){
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(data);
    }

    /**
     *  返回分页数据信息
     *
     * @param code      响应结果编码
     * @param message   响应结果信息
     * @param count     响应数据条数
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(int code, String message, long count, T data){
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(count)
                .data(data);
    }

    /**
     *  返回处理结果
     *
     * 针对于返回业务处理之后，需要向前端反馈后台处理的数据，将其返回
     *
     * @param responseCode   响应状态
     * @param count          响应数据条数
     * @param data           响应数据
     * @author Jiangxincan
     * @date 2019/12/20 14:41
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> success(ResponseCode responseCode, long count, T data) {
        return new ResponseObject<T>(responseCode)
                .count(count)
                .data(data);
    }


    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error() {
        return new ResponseObject<T>(ResponseCode.REQUEST_ERROR)
                .count(0)
                .msg(ResponseCode.REQUEST_ERROR.message())
                .data(null);
    }

    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @param responseCode      响应状态
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(ResponseCode responseCode) {
        return new ResponseObject<T>(responseCode)
                .count(0)
                .msg(responseCode.message())
                .data(null);
    }

    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默认返回失败处理信息
     *
     * @param responseCode      响应状态
     * @param data              响应数据
     * @param <T>               响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(ResponseCode responseCode, T data) {
        return new ResponseObject<T>(responseCode)
                .count(0)
                .data(data);
    }

    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息
     *
     * @param message   响应结果信息
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(String message) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_ERROR)
                .msg(message)
                .count(0)
                .data(null);
    }

    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息并返回传入修改的信息
     *
     * @param message   响应结果信息
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(String message, T data) {
        return new ResponseObject<T>()
                .code(ResponseCode.REQUEST_ERROR)
                .msg(message)
                .count(0)
                .data(data);
    }

    /**
     *  返回处理结果
     *
     * 针对于系统业务处理失败之后，系统默返回自定义失败处理信息并返回传入修改的信息
     *
     * @param message   响应结果信息
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(Integer code, String message) {
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(null);
    }

    /**
     *  返回处理结果
     *
     * token过期传入code,或其他的错误传入code值
     *
     * @param code      响应结果编码
     * @param message   响应结果信息
     * @param data      响应数据
     * @param <T>       响应数据类型
     * @author Jiangxincan
     * @date 2019/12/17 20:30
     * @return cn.com.xincan.xincanframework.common.ResponseObject<T>
     */
    public static <T> ResponseObject<T> error(Integer code, String message, T data) {
        return new ResponseObject<T>()
                .code(code)
                .msg(message)
                .count(0)
                .data(data);
    }

}
