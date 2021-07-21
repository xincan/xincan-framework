package cn.com.xincan.xincanframework.server.order.service.impl;

import cn.com.xincan.xincanframework.entity.order.dto.OrderPatchDto;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderGoodsMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderGoodsPo;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderPo;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    @Resource
    private IOrderGoodsMapper orderGoodsMapper;

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
     *  根据用户ID查询订单信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    public OrderSearchVo findOrderByUserId(String id) {
        LambdaQueryWrapper<OrderPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(!StringUtils.isEmpty(id), OrderPo::getUserId, id);
        OrderPo user = orderMapper.selectOne(queryWrapper);
        return OrikaUtils.map(user, OrderSearchVo.class);
    }

    /**
     *  分页查询用户信息
     * @param orderSearchDto 订单信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto>
     */
    @Override
    public Page<OrderSearchVo> page(OrderSearchDto orderSearchDto){
        Page<OrderPo> page = new Page<>(orderSearchDto.getPage(), orderSearchDto.getLimit());
        LambdaQueryWrapper<OrderPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(orderSearchDto.getUserId()), OrderPo::getUserId, orderSearchDto.getUserId());
        page = orderMapper.selectPage(page, queryWrapper);
        Page<OrderSearchVo> record = new Page<>();
        record.setRecords(OrikaUtils.mapAsList(page.getRecords(), OrderSearchVo.class));
        record.setTotal(page.getTotal());
        return record;

    }

    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author Jiangxincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderSearchVo save(OrderSaveDto orderSaveDto) {
        OrderPo orderPo = OrikaUtils.map(orderSaveDto, OrderPo.class);
        orderMapper.insert(orderPo);
        OrderGoodsPo orderGoodsPo = OrderGoodsPo.builder()
                .orderId(orderPo.getId()).goodsId(orderSaveDto.getGoodsId()).userId(orderSaveDto.getUserId()).build();
        orderGoodsMapper.insert(orderGoodsPo);
        return OrikaUtils.map(orderPo, OrderSearchVo.class);
    }

    /**
     *  修改订单信息
     * @param orderPatchDto 修改订单信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.order.dto.OrderSearchVo
     */
    @Override
    public OrderSearchVo patch(OrderPatchDto orderPatchDto) {
        OrderPo userPo = OrikaUtils.map(orderPatchDto, OrderPo.class);
        orderMapper.updateById(userPo);
        return OrikaUtils.map(orderPatchDto, OrderSearchVo.class);
    }

    /**
     *  删除用户信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    @Override
    public int delete(String id) {
        LambdaQueryWrapper<OrderPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderPo::getId, id);
        return orderMapper.delete(queryWrapper);
    }


}
