package cn.com.xincan.xincanframework.server.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/22 9:39             1.0                         用户保存参数实体类
 * @program xincan-framework
 * @description 用户保存参数实体类
 * @create 2020/7/22 9:39
 */
@ApiModel(description = "保存用户信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveDto {

    @ApiModelProperty(value="用户名称", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(value="用户登录名称", dataType = "String", example = "zhangsan")
    private String loginName;

    @ApiModelProperty(value="用户登录密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(value="用户电话", dataType = "String", example = "18503455667")
    private String phone;

    @ApiModelProperty(value="创建时间", dataType = "LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
