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
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单查询实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:54              0.0.1                       订单查询实体类
 */
@ApiModel(description = "订单参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSaveDto {

    @ApiModelProperty(value="用户ID（下订单的人ID）", required = true, dataType = "String", example = "1285759156342562818")
    @NotBlank(message = "订单人ID不能为空")
    @Length(message = "订单人ID长度应为{min}位", min = 19, max = 19)
    private String userId;

    @ApiModelProperty(value="商品ID（用户选中的商品ID）", required = true, dataType = "String", example = "1417457974364454913")
    @NotBlank(message = "商品ID不能为空")
    @Length(message = "商品ID长度应为{min}位", min = 19, max = 19)
    private String goodsId;

    @ApiModelProperty(value="订单说明（附加信息）", dataType = "String", example = "注意物件不能轻易碰撞")
    private String description;

}
