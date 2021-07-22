package cn.com.xincan.xincanframework.server.order.service;

import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 更新补丁接口类
 * @create 2020/3/19 14:35
 */
public interface IOrderGoodsService {

    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author Jiangxincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo save(OrderSaveDto orderSaveDto);

}
