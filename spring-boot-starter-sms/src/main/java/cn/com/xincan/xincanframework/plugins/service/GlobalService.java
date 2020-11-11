package cn.com.xincan.xincanframework.plugins.service;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 消息发送全局接口
 * @create 2020/11/11 14:01
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/11/11 14:01             1.0                         消息发送全局接口
 */
public interface GlobalService<T> {

    T send();

}
