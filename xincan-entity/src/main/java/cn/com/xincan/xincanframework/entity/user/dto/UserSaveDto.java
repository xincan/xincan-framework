package cn.com.xincan.xincanframework.entity.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 用户保存参数实体类
 * @create 2020/7/22 9:39
 */
@ApiModel(description = "保存用户信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSaveDto  implements Serializable {

    private static final long serialVersionUID = 3184713806799151483L;

    @ApiModelProperty(value="用户名称", dataType = "String", required = true, example = "张三")
    @NotBlank(message = "用户名称不能为空")
    @Length(message = "用户名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String name;

    @ApiModelProperty(value="用户登录名称", dataType = "String", required = true, example = "zhangsan")
    @NotBlank(message = "登录名称不能为空")
    @Length(message = "登录名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String loginName;

    @ApiModelProperty(value="登录密码", dataType = "String", required = true, example = "123456")
    @NotBlank(message = "登录密码不能为空")
    @Length(message = "登录密码长度应在{min}~{max}之间", min = 6, max = 20)
    private String password;

    @ApiModelProperty(value="用户电话", dataType = "String", example = "18503455667")
    @Length(message = "用户电话长度应为{min}位", min = 11, max = 11)
    private String phone;

    @ApiModelProperty(value="用户邮箱", dataType = "String", example = "alittlexincan@163.com")
    @Length(message = "用户邮箱长度应为{min}位", min = 10, max = 50)
    private String email;

    @ApiModelProperty(value="用户地址", dataType = "String", example = "北京市海淀区西直门")
    private String address;

    @ApiModelProperty(value="用户余额", dataType = "java.math.BigDecimal", example = "10000000.01")
    @DecimalMax(message = "用户余额最大值为{value}", value = "99999999.99")
    @DecimalMin(message = "用户余额最大值为{value}", value = "00000000.00")
    private BigDecimal balance;


}
