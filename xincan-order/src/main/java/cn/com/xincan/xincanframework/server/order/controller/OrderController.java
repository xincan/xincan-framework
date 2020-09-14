package cn.com.xincan.xincanframework.server.order.controller;

import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单信息控制层
 * @create 2020/3/19 14:37
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:37             0.0.1                         订单信息控制层
 */
@Slf4j
@Api(tags = {"订单信息管理"})
@RestController
@RequestMapping("/order")
public class OrderController {

    @Qualifier("orderService")
    private final IOrderService orderService;

    public OrderController(IOrderService userService){
        this.orderService = userService;
    }

    @ApiOperation(value = "查询订单信息", httpMethod = "GET", notes = "查询所有订单信息")
    @GetMapping
    public ResponseObject<List<OrderSearchVo>> find() {
        return ResponseResult.success(orderService.findAll());
    }

    @ApiOperation(value = "新增订单信息", httpMethod = "PUT", notes = "新增订单信息")
    @PutMapping
    public ResponseObject<OrderSearchVo> find(@ApiParam OrderSaveDto studentDTO) {
        return ResponseResult.success(orderService.save(studentDTO));
    }

    @ApiOperation(value = "根据订单ID查询订单信息", httpMethod = "GET", notes = "根据订单ID查询订单信息")
    @GetMapping("/{id}")
    public ResponseObject<OrderSearchVo> findOrderById(
            @ApiParam(name = "id", value = "订单ID", required = true, example = "1269912454821879810")
            @Validated @PathVariable(name = "id") String id
    ) {
        return ResponseResult.success(orderService.findOrderById(id));
    }

    @ApiOperation(value = "根据订单参数查询订单信息", httpMethod = "GET", notes = "根据订单ID、用户ID、订单名称查询订单详细信息")
    @GetMapping("/params")
    public ResponseObject<OrderSearchVo> findOrderByParams( @Validated OrderSearchDto orderSearchDto) {
        return ResponseResult.success(orderService.findOrderByParams(orderSearchDto));
    }

}
