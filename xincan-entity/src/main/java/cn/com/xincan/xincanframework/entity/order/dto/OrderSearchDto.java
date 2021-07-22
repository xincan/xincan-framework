package cn.com.xincan.xincanframework.entity.order.dto;

import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单信息查询实体类
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "订单信息查询实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchDto extends PaginationQuery  implements Serializable {

    private static final long serialVersionUID = 2802713323202618595L;

    @ApiModelProperty(name = "id", value="订单ID（UUID）", dataType = "String", example = "1285522130867376129")
    @Length(message = "订单ID长度应为{min}位", min = 19, max = 19)
    private String id;

    @ApiModelProperty(value="用户ID（下订单的人ID）", required = true, dataType = "String", example = "1285759156342562818")
    @Length(message = "订单人ID长度应为{min}位", min = 19, max = 19)
    private String userId;

    @ApiModelProperty(value="商品ID（用户选中的商品ID）", required = true, dataType = "String", example = "1417457974364454913")
    @Length(message = "商品ID长度应为{min}位", min = 19, max = 19)
    private String goodsId;

    @ApiModelProperty(value="订单说明（附加信息）", dataType = "String", example = "注意物件不能轻易碰撞")
    private String description;

}
