package cn.com.xincan.xincanframework.server.memory.controller;

import cn.com.xincan.xincanframework.utils.MemoryUtil;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/** copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 混沌工程测试类
 * @author JiangXincan
 * @create 2021/9/9 13:18
 * @version 2.0.0
 */
@Slf4j
@Api(tags = {"混沌工程资源满载测试"})
@RestController
@RequestMapping("/chaos")
@Validated
public class ChaosController {

    @ApiOperation(value = "内存统计", httpMethod = "GET", notes = "统计计算内存占用信息")
    @GetMapping("memory")
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


}
