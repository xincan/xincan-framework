package cn.com.xincan.xincanframework.server.order.service.impl;

import cn.com.xincan.xincanframework.client.order.GoodsClient;
import cn.com.xincan.xincanframework.config.excetion.OrderException;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import cn.com.xincan.xincanframework.entity.order.dto.OrderPatchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderGoodsMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderGoodsPo;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderPo;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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
public class OrderServiceImpl implements IOrderService {


    @Resource
    private IOrderMapper orderMapper;

    @Resource
    private IOrderGoodsMapper orderGoodsMapper;

    private final GoodsClient goodsClient;

    public OrderServiceImpl(GoodsClient goodsClient) {
        this.goodsClient = goodsClient;
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
        LambdaQueryWrapper<OrderPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(!StringUtils.isEmpty(id), OrderPo::getUserId, id);
        OrderPo user = orderMapper.selectOne(queryWrapper);
        return OrikaUtils.map(user, OrderSearchVo.class);

    }

    /**
     *  根据用户ID查询订单信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo
     */
    @Override
    public OrderGoodsSearchVo findOrderByUserId(String id) {

        LambdaQueryWrapper<OrderPo> orderPoLambdaQueryWrapper = Wrappers.lambdaQuery();
        orderPoLambdaQueryWrapper.eq(StringUtils.isEmpty(id), OrderPo::getUserId, id);

        // 根据用户ID，获取订单基本信息
        OrderPo orderPo = orderMapper.selectOne(orderPoLambdaQueryWrapper);

        // 根据用户ID，获取订单对应商品映射信息
        LambdaQueryWrapper<OrderGoodsPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(!StringUtils.isEmpty(id), OrderGoodsPo::getUserId, id);
        List<OrderGoodsPo> orderGoodsPoList = orderGoodsMapper.selectList(queryWrapper);

        // 根据商品ID集合获取商品详细信息
        List<String> goodsIds = orderGoodsPoList.stream().map(OrderGoodsPo::getGoodsId).collect(Collectors.toList());
        // 通过商品客户端远程调用商品服务获取商品信息
        ResponseObject<List<GoodsSearchVo>> responseObject = goodsClient.findGoodsByIds(goodsIds);
        if(responseObject.getCode() == ResponseCode.REQUEST_SERVICE_ERROR.code()){
            throw new OrderException(responseObject.getCode(), responseObject.getMsg());
        }
        List<GoodsSearchVo> goodsSearchList = responseObject.getData();

        OrderGoodsSearchVo orderSearchVo = OrikaUtils.map(orderPo, OrderGoodsSearchVo.class);
        orderSearchVo.setGoods(goodsSearchList);
        return orderSearchVo;

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
        saveOrderGoodsBatch(orderPo.getId(), orderSaveDto.getGoodsId(), orderSaveDto.getUserId());
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

    /**
     * 插入订单与商品的关联关系
     * @param orderId 订单ID
     * @param goodsId  商品ID集合
     * @param userId  用户ID
     * @author JiangXincan
     * @date 2021/7/21 14:27
     * @return void
     **/
    private void saveOrderGoodsBatch(String orderId, List<String> goodsId, String userId) {
        goodsId.forEach(goods -> {
            OrderGoodsPo orderGoodsPo = OrderGoodsPo.builder().orderId(orderId).goodsId(goods).userId(userId).build();
            orderGoodsMapper.insert(orderGoodsPo);
        });
    }

}
