package cn.com.xincan.xincanframework.entity.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 修改订单实体类
 * @create 2020/9/15 15:59
 */
@ApiModel(description = "修改订单信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPatchDto  implements Serializable {

    private static final long serialVersionUID = -4475880628965067332L;

    @ApiModelProperty(value="订单ID", dataType = "String", required = true, example = "415c2c7adda93c37d7a3d5aea99d8e25")
    @NotBlank(message = "订单ID不能为空")
    @Length(message = "订单ID长度应为{min}位", min = 19, max = 19)
    private String id;

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
