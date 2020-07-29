package cn.com.xincan.xincanframework.server.order.service;

import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-order
 * 更新补丁接口类
 * @create 2020/3/19 14:35
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:35             0.0.1                         更新补丁接口类
 */
public interface IOrderService {

    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author JiangXincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo save(OrderSaveDto orderSaveDto);

    /**
     *  查询所有订单信息
     * @author JiangXincan
     * @date 2020/7/21 13:58
     * @return java.util.List<cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo>
     */
    List<OrderSearchVo> findAll();

    /**
     *  根据订单ID查询订单信息
     * @param id 订单ID
     * @author JiangXincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo findOrderById(String id);

    /**
     *  根据部分参数查询订单信息
     * @param orderSearchDto 参数对象
     * @author JiangXincan
     * @date 2020/7/21 17:18
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo findOrderByParams(OrderSearchDto orderSearchDto);


}
