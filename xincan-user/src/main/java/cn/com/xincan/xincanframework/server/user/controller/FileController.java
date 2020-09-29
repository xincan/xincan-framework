package cn.com.xincan.xincanframework.server.user.controller;

import cn.com.xincan.xincanframework.config.log.LogType;
import cn.com.xincan.xincanframework.config.log.OptionLog;
import cn.com.xincan.xincanframework.entity.user.dto.UserPatchDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Api(tags = {"文件信息管理"})
@RestController
@RequestMapping("file")
@Validated
public class FileController {

    @ApiOperation(value = "上传文件信息", httpMethod = "POST", notes = "根据文件路径上传文件信息")
    @PostMapping("upload")
    @OptionLog(type = LogType.BUSINESS_UPLOAD)
    public ResponseObject<UserSearchVo> uploadFile(
            @ApiParam(name = "file", value = "文件名称", required = true, example = "D:/kube-flannel.yml")
            @NotNull(message = "文件不能为空")
            @RequestParam("file")
            MultipartFile file
    ) {
        return ResponseResult.success();
    }

    @ApiOperation(value = "下载文件信息", httpMethod = "GET", notes = "根据文件路径下载文件信息")
    @GetMapping("download")
    @OptionLog(type=LogType.BUSINESS_DOWNLOAD)
    public ResponseObject<UserSearchVo> downloadFile(
            @ApiParam(name = "fileUrl", value = "文件路径", required = true, example = "D:/kube-flannel.yml")
            @NotBlank(message = "文件路径不能为空")
            @RequestParam(name = "fileUrl")
            String fileUrl
    ) {
        return ResponseResult.success();
    }

    @ApiOperation(value = "导入文件信息", httpMethod = "POST", notes = "根据文件路径导入文件信息")
    @PostMapping("import")
    @OptionLog(type=LogType.BUSINESS_IMPORT)
    public ResponseObject<Integer> importFile(
            @ApiParam(name = "files", value = "文件名称", required = true, example = "D:/kube-flannel.yml,aa.zip")
            @NotNull(message = "文件不能为空")
            @RequestParam("files")
            MultipartFile[] multipartFiles
    ) {
        return ResponseResult.success();
    }

    @ApiOperation(value = "导出文件信息", httpMethod = "GET", notes = "根据文件路径导出文件信息")
    @GetMapping("export")
    @OptionLog(type=LogType.BUSINESS_EXPORT)
    public ResponseObject<Integer> exportFile() {
        return ResponseResult.success();
    }

}
