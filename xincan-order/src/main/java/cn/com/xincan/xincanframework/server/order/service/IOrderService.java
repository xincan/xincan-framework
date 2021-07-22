package cn.com.xincan.xincanframework.server.order.service;

import cn.com.xincan.xincanframework.entity.order.dto.OrderPatchDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 更新补丁接口类
 * @create 2020/3/19 14:35
 */
public interface IOrderService {

    /**
     *  查询所有订单信息
     * @author Jiangxincan
     * @date 2020/7/21 13:58
     * @return java.util.List<cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo>
     */
    List<OrderSearchVo> findAll();

    /**
     *  根据订单ID查询订单信息
     * @param id 订单ID
     * @author Jiangxincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo findOrderById(String id);

    /**
     *  根据用户ID查询订单信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/21 13:59
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo
     */
    OrderGoodsSearchVo findOrderByUserId(String id);


    /**
     *  根据用户ID，查询用户详细信息实体类
     * @param orderSearchDto 订单信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.order.dto.OrderSearchVo>
     */
    Page<OrderSearchVo> page(OrderSearchDto orderSearchDto);

    /**
     *  保存订单信息
     * @param orderSaveDto 订单信息实体
     * @author Jiangxincan
     * @date 2020/7/21 16:58
     * @return cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo
     */
    OrderSearchVo save(OrderSaveDto orderSaveDto);

    /**
     *  修改订单信息
     * @param orderPatchDto 修改订单信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.order.dto.OrderPatchDto
     */
    OrderSearchVo patch(OrderPatchDto orderPatchDto);

    /**
     *  删除订单信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    int delete(String id);

}
