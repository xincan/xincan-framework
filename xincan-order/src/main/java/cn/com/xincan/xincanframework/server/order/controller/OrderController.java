package cn.com.xincan.xincanframework.server.order.controller;

import cn.com.xincan.xincanframework.common.ResponseObject;
import cn.com.xincan.xincanframework.common.ResponseResult;
import cn.com.xincan.xincanframework.server.order.dto.OrderDTO;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import cn.com.xincan.xincanframework.server.order.vo.OrderVO;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * 订单信息控制层
 * @create 2020/3/19 14:37
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:37             1.0                         订单信息控制层
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
    public ResponseObject<List<OrderVO>> find() {
        return ResponseResult.success(orderService.findAll());
    }

    @ApiOperation(value = "新增订单信息", httpMethod = "PUT", notes = "新增订单信息")
    @PutMapping
    public ResponseObject<OrderVO> find(@ApiParam OrderDTO studentDTO) {
        return ResponseResult.success(orderService.save(studentDTO));
    }

    @ApiOperation(value = "根据订单ID查询订单信息", httpMethod = "GET", notes = "根据订单ID查询订单信息")
    @GetMapping("/{id}")
    public ResponseObject<OrderVO> findUserById(
            @ApiParam(name = "id", value = "订单ID", required = true, example = "1269912454821879810")
            @Validated @PathVariable(name = "id") String id
    ) {
        return ResponseResult.success(orderService.findUserById(id));
    }

}
