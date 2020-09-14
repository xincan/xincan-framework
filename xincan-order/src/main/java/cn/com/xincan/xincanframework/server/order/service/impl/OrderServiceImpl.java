package cn.com.xincan.xincanframework.server.order.service.impl;

import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderPo;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单接口实现类
 * @create 2020/3/19 14:36
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:36             0.0.1                       订单接口实现类
 */
@Component
public class OrderServiceImpl implements IOrderService {


    @Resource
    private IOrderMapper orderMapper;

    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author Jiangxincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    public OrderSearchVo save(OrderSaveDto orderSaveDto) {
        OrderPo orderPo = OrikaUtils.map(orderSaveDto, OrderPo.class);
        orderMapper.insert(orderPo);
        return OrikaUtils.map(orderPo, OrderSearchVo.class);
    }

    /**
     *  查询所有订单信息
     * @author Jiangxincan
     * @date 2020/7/21 13:58
     * @return java.util.List<cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo>
     */
    @Override
    public List<OrderSearchVo> findAll() {
        List<OrderPo> lists =  orderMapper.selectList(null);
        return OrikaUtils.mapAsList(lists, OrderSearchVo.class);

    }

    /**
     *  根据订单ID查询订单信息
     * @param id 订单ID
     * @author Jiangxincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    public OrderSearchVo findOrderById(String id) {
        OrderPo user = orderMapper.selectById(id);
        return OrikaUtils.map(user, OrderSearchVo.class);
    }

    /**
     *  根据部分参数查询订单信息
     * @param orderSearchDto 参数对象
     * @author Jiangxincan
     * @date 2020/7/21 17:18
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    public OrderSearchVo findOrderByParams(OrderSearchDto orderSearchDto) {

        if(ObjectUtils.isEmpty(orderSearchDto)) {
            return null;
        }

        LambdaQueryWrapper<OrderPo> lambdaQueryWrapper = new LambdaQueryWrapper<OrderPo>();

        if( !StringUtils.isEmpty(orderSearchDto.getId())) {
            lambdaQueryWrapper.eq(OrderPo::getId, orderSearchDto.getId());
        }else if( !StringUtils.isEmpty(orderSearchDto.getUserId())) {
            lambdaQueryWrapper.eq(OrderPo::getUserId, orderSearchDto.getUserId());
        }else if( !StringUtils.isEmpty(orderSearchDto.getTitle())) {
            lambdaQueryWrapper.eq(OrderPo::getTitle, orderSearchDto.getTitle());
        }

        OrderPo orderPo = orderMapper.selectOne(lambdaQueryWrapper);

        return OrikaUtils.map(orderPo, OrderSearchVo.class);
    }

}
