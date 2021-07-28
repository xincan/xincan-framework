package cn.com.xincan.xincanframework.plugins.service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 消息发送全局接口
 * @create 2020/11/11 14:01
 */
public abstract class GlobalService<T> {

    public abstract T send(String message);

}
