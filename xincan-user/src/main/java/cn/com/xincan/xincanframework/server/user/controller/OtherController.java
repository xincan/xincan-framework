package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.config.log.LogType;
import cn.com.xincan.xincanframework.config.log.OptionLog;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/22 16:35             1.0                         文件操作控制层
 * @program xincan-framework
 * @description 文件操作控制层
 * @create 2020/9/22 16:35
 */
@Api(tags = {"其他信息管理"})
@RestController
@RequestMapping("file")
@Validated
public class OtherController {


    @ApiOperation(value = "查询用户信息List", httpMethod = "POST", notes = "根据参数列表list查询列表信息")
    @PostMapping("list")
    @OptionLog(type = LogType.BUSINESS_SEARCH)
    public ResponseObject<List<UserSearchVo>> page(@ApiParam @Validated @RequestBody List<UserSearchDto> lists) {

        return ResponseResult.success();
    }

    @ApiOperation(value = "查询用户信息Map", httpMethod = "POST", notes = "根据参数列表map查询列表信息")
    @PostMapping("map")
    @OptionLog(type = LogType.BUSINESS_SEARCH)
    public ResponseObject<UserSearchVo> save(@ApiParam @Validated Map<String, UserSaveDto> map) {
        return ResponseResult.success();
    }


}
