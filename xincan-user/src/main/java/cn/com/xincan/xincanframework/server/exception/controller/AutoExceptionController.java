package cn.com.xincan.xincanframework.server.exception.controller;

import cn.com.xincan.xincanframework.config.exception.BusinessException;
import cn.com.xincan.xincanframework.utils.common.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.common.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/8 21:24             1.0                         自定义异常处理控制层
 * @program xincan-framework
 * @description 自定义异常处理控制层
 * @create 2020/9/8 21:24
 */
@Api(tags = {"异常测试管理"})
@RestController
@RequestMapping("exception")
public class AutoExceptionController {

    @ApiOperation(value = "自定义业务异常", httpMethod = "GET", notes = "自定义业务异常测试BusinessException")
    @GetMapping
    public ResponseObject<String> aa(){

        if(1 == 1){
            throw new BusinessException("业务数据不能为空");
        }

        return ResponseResult.success();
    }

}
