package cn.com.xincan.xincanframework.entity.order.dto;

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
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 修改订单实体类
 * @create 2020/9/15 15:59
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/15 15:59             1.0                         修改订单实体类
 */
@ApiModel(description = "修改订单信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPatchDto {

    @ApiModelProperty(value="订单ID", dataType = "String", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
    @NotBlank(message = "订单ID不能为空")
    @Length(message = "订单ID长度应为{min}位", min = 32, max = 32)
    private String id;

    @ApiModelProperty(value="订单名称", dataType = "String", example = "购买佛珠")
    @Length(message = "订单名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String title;

    @ApiModelProperty(value="订单地址（收货地址）", dataType = "String", example = "北京市房山区")
    @Length(message = "订单名称长度应在{min}~{max}之间", min = 1, max = 200)
    private String address;

    @ApiModelProperty(value="订单人ID（收货人ID、UUID）", dataType = "String", example = "1285759156342562818")
    @Length(message = "订单ID长度应为{min}位", min = 32, max = 32)
    private String userId;

    @ApiModelProperty(value="订单说明（附加信息）", dataType = "String", example = "注意物件不能轻易碰撞")
    private String description;


}
