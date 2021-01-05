package cn.com.xincan.xincanframework.entity.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;





/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 0.0.1
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/22 9:39             0.0.1                         用户修改参数实体类
 * @program xincan-framework
 * @description 用户修改参数实体类
 * @create 2020/7/22 9:39
 */
@ApiModel(description = "修改用户信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPatchDto {

    @ApiModelProperty(value="用户ID", dataType = "String", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
    @NotBlank(message = "用户ID不能为空")
    @Length(message = "用户ID长度应为{min}位", min = 19, max = 19)
    private String id;

    @ApiModelProperty(value="用户名称", dataType = "String", example = "张三")
    @Length(message = "用户名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String name;

    @ApiModelProperty(value="用户登录名称", dataType = "String", example = "zhangsan")
    @Length(message = "登录名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String loginName;

    @ApiModelProperty(value="登录密码", dataType = "String", example = "123456")
    @Length(message = "登录密码长度应在{min}~{max}之间", min = 6, max = 20)
    private String password;

    @ApiModelProperty(value="用户电话", dataType = "String", example = "18503455667")
    @Length(message = "用户电话长度应为{min}位", min = 11, max = 11)
    private String phone;

    @ApiModelProperty(value="创建时间", dataType = "LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
