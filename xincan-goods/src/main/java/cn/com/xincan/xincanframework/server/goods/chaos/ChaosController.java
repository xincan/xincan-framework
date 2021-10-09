package cn.com.xincan.xincanframework.server.goods.chaos;

import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSearchDto;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import cn.com.xincan.xincanframework.server.goods.service.IGoodsService;
import cn.com.xincan.xincanframework.utils.MemoryUtil;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import cn.com.xincan.xincanframework.utils.response.ResponseResultBody;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/** copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 混沌工程测试类
 * @author JiangXincan
 * @create 2021/9/9 13:18
 * @version 2.0.0
 */
@Slf4j
@Api(tags = {"混沌工程测试"})
@RestController
@RequestMapping("/chaos")
@Validated
@ResponseResultBody
public class ChaosController {

    private final IGoodsService goodsService;

    public ChaosController(IGoodsService goodsService){
        this.goodsService = goodsService;
    }

    @ApiOperation(value = "熔断降级", httpMethod = "POST", notes = "根据参数列表查询部分商品列表信息")
    @PostMapping
    @SentinelResource(value = "/post/goods", fallback = "pageFallback")
    public ResponseObject<List<GoodsSearchVo>> page(@ApiParam @Validated @RequestBody GoodsSearchDto goodsSearchDto) {
        Page<GoodsSearchVo> page = goodsService.page(goodsSearchDto);
        return ResponseResult.success(page.getTotal(), page.getRecords());
    }

    @ApiOperation(value = "内存统计", httpMethod = "GET", notes = "统计计算内存占用信息")
    @GetMapping("memory")
    @SentinelResource(value = "/memory", fallback = "computerFallback")
    public ResponseObject<JSONObject> memory(
            @ApiParam(name = "num", value = "循环次数", required = true, example = "100000")
            @NotNull(message = "循环次数不能为空")
            @RequestParam("num") int num
    ) {
        MemoryUtil.run.gc();
        long startTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        JSONObject before = MemoryUtil.getMemory();
        for(int i = 0; i < num; i++){
            Math.hypot(i * 2, i * 3);
        }
        JSONObject after = MemoryUtil.getMemory();
        long endTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long time = endTime - startTime;
        System.out.println("耗时：" + time);

        JSONObject result = new JSONObject();
        result.put("before", before);
        result.put("after", after);

        return ResponseResult.success(result);
    }

    @ApiOperation(value = "CPU统计", httpMethod = "GET", notes = "统计计算CPU使用率")
    @GetMapping("cpu")
    @SentinelResource(value = "/cpu", fallback = "computerFallback")
    public ResponseObject<JSONObject> cpu(
            @ApiParam(name = "num", value = "循环次数", required = true, example = "100000")
            @NotNull(message = "循环次数不能为空")
            @RequestParam("num") int num
    ) {

        long beforeTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        for(int i = 0; i < num; i++){
            Math.hypot(i * 2, i * 3);
        }
        long afterTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        JSONObject result = new JSONObject();
        result.put("before", beforeTime);
        result.put("after", afterTime);
        result.put("result",(afterTime - beforeTime));
        return ResponseResult.success(result);
    }

    public ResponseObject<List<GoodsSearchDto>> pageFallback(GoodsSearchDto goodsSearchDto) {
        log.info("商品ID：【{}】", goodsSearchDto.getId());
        return ResponseResult.error(ResponseCode.CHAOS_JIANGJI);
    }

    public ResponseObject<JSONObject> computerFallback(int num) {
        log.info("循环次数：", num);
        return ResponseResult.error(ResponseCode.CHAOS_JIANGJI);
    }


    @ApiOperation(value = "API POST传参测试(单值)", httpMethod = "POST", notes = "API POST传参测试")
    @PostMapping("id")
    @SentinelResource
    public ResponseObject<GoodsSearchVo> post(
            @ApiParam(name = "id", value = "商品ID", required = true, example = "1417457974364454913")
            @NotNull(message = "商品ID不能为空")
            @RequestParam("id") String id
    ) {
        GoodsSearchVo goodsSearchVo = new GoodsSearchVo();
        goodsSearchVo.setId(id);
        return ResponseResult.success(goodsSearchVo);
    }

    @ApiOperation(value = "API POST传参测试（对象）", httpMethod = "POST", notes = "API POST传参测试")
    @PostMapping("object")
    @SentinelResource
    public ResponseObject<GoodsSearchVo> object(
           @ApiParam @Validated @RequestBody GoodsSearchDto goodsSearchDto
    ) {
        GoodsSearchVo goodsSearchVo = OrikaUtils.map(goodsSearchDto, GoodsSearchVo.class);
        return ResponseResult.success(goodsSearchVo);
    }


}
