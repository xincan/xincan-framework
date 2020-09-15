package cn.com.xincan.xincanframework.server.order.controller;

import cn.com.xincan.xincanframework.entity.order.dto.OrderPatchDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSaveDto;
import cn.com.xincan.xincanframework.entity.order.dto.OrderSearchDto;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
@Validated
@RequestMapping("/order")
public class OrderController {

    @Qualifier("orderService")
    private final IOrderService orderService;

    public OrderController(IOrderService userService){
        this.orderService = userService;
    }

    @ApiOperation(value = "根据订单ID查询订单信息", httpMethod = "GET", notes = "根据订单ID查询订单信息")
    @GetMapping("/{id}")
    public ResponseObject<OrderSearchVo> findOrderById(
            @ApiParam(name = "id", value = "订单ID", required = true, example = "1269912454821879810")
            @Length(message = "订单ID长度应为32位", min = 32, max = 32)
            @PathVariable(name = "id")
            String id
    ) {
        return ResponseResult.success(orderService.findOrderById(id));
    }

    @ApiOperation(value = "查询订单信息（分页）", httpMethod = "POST", notes = "根据参数列表查询部分订单列表信息")
    @PostMapping
    public ResponseObject<List<OrderSearchVo>> page(@ApiParam @Validated @RequestBody OrderSearchDto orderSearchDto) {
        Page<OrderSearchVo> page = orderService.page(orderSearchDto);
        return ResponseResult.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "新增订单信息", httpMethod = "PUT", notes = "新增订单信息")
    @PutMapping
    public ResponseObject<OrderSearchVo> save(@ApiParam @Validated OrderSaveDto orderSaveDto) {
        return ResponseResult.success(orderService.save(orderSaveDto));
    }

    @ApiOperation(value = "修改订单信息", httpMethod = "PATCH", notes = "根据参数列表修改订单信息")
    @PatchMapping
    public ResponseObject<OrderSearchVo> patch(@ApiParam @Validated OrderPatchDto orderPatchDto) {
        return ResponseResult.success(orderService.patch(orderPatchDto));
    }

    @ApiOperation(value = "删除订单信息", httpMethod = "DELETE", notes = "根据ID删除订单信息")
    @DeleteMapping
    public ResponseObject<Integer> delete(
            @ApiParam(name = "id", value = "订单ID", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
            @NotBlank(message = "订单ID不能为空")
            @Length(message = "订单ID长度应为32位", min = 32, max = 32)
            @RequestParam(name = "id")
            String id
    ) {
        return ResponseResult.success(1, orderService.delete(id));
    }



}
