package cn.com.xincan.xincanframework.server.order.service.impl;

import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderGoodsMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderGoodsPo;
import cn.com.xincan.xincanframework.server.order.service.IOrderGoodsService;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单接口实现类
 * @create 2020/3/19 14:36
 */
@Component
public class OrderGoodsServiceImpl implements IOrderGoodsService {


    @Resource
    private IOrderGoodsMapper orderGoodsMapper;



    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author Jiangxincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    public OrderSearchVo save(OrderSaveDto orderSaveDto) {
        OrderGoodsPo orderGoodsPo = OrikaUtils.map(orderSaveDto, OrderGoodsPo.class);
        orderGoodsMapper.insert(orderGoodsPo);
        return OrikaUtils.map(orderGoodsPo, OrderSearchVo.class);
    }


}
