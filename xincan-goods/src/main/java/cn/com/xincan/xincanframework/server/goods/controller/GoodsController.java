package cn.com.xincan.xincanframework.server.goods.controller;

import cn.com.xincan.xincanframework.entity.goods.dto.GoodsPatchDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSaveDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSearchDto;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import cn.com.xincan.xincanframework.server.goods.service.IGoodsService;
import cn.com.xincan.xincanframework.utils.response.*;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-goods
 * 商品信息控制层
 * @create 2020/3/19 14:37
 */
@Slf4j
@Api(tags = {"商品信息管理"})
@RestController
@RequestMapping("/goods")
@Validated
@ResponseResultBody
public class GoodsController {

    private final IGoodsService goodsService;

    public GoodsController(IGoodsService goodsService){
        this.goodsService = goodsService;
    }

    @ApiOperation(value = "查询商品信息", httpMethod = "GET", notes = "根据商品ID查询商品详细信息")
    @ApiImplicitParam(name = "ids", value = "商品ID（多个逗号隔开）", required = true, dataType = "String", allowMultiple = true , example = "1417457974364454913,1417726917956083714")
    @GetMapping("/{ids}")
    @SentinelResource("/{ids}")
    public List<GoodsSearchVo> findGoodsById(
            @NotNull(message = "商品ID不能为空")
            @PathVariable(name = "ids")
            List<String> ids
    ) {
        return goodsService.findGoodsByIds(ids);
    }

    @ApiOperation(value = "查询商品信息（分页）", httpMethod = "POST", notes = "根据参数列表查询部分商品列表信息")
    @PostMapping
    @SentinelResource("/post/goods")
    public ResponseObject<List<GoodsSearchVo>> page(@ApiParam @Validated @RequestBody GoodsSearchDto goodsSearchDto) {
        Page<GoodsSearchVo> page = goodsService.page(goodsSearchDto);
        return ResponseResult.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "新增商品信息", httpMethod = "PUT", notes = "新增商品信息")
    @PutMapping
    @SentinelResource("/put/goods")
    public GoodsSearchVo save(@ApiParam @Validated GoodsSaveDto goodsSaveDto) {
        return goodsService.save(goodsSaveDto);
    }

    @ApiOperation(value = "修改商品信息", httpMethod = "PATCH", notes = "根据参数列表修改商品信息")
    @PatchMapping
    @SentinelResource("/patch/goods")
    public GoodsSearchVo patch(@ApiParam @Validated GoodsPatchDto goodsPatchDto) {
        return goodsService.patch(goodsPatchDto);
    }

    @ApiOperation(value = "删除商品信息", httpMethod = "DELETE", notes = "根据ID删除商品信息")
    @DeleteMapping
    @SentinelResource("/delete/goods")
    public Integer delete(
            @ApiParam(name = "id", value = "商品ID", required = true, example = "1285759156342562818")
            @NotNull(message = "商品ID不能为空")
            @Length(message = "商品ID长度应为{max}位", min = 19, max = 19)
            @RequestParam(name = "id")
            String id
    ) {
        return goodsService.delete(id);
    }

}
