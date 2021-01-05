package cn.com.xincan.xincanframework.entity.order.dto;

import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单信息查询实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:54             0.0.1                       订单信息查询实体类
 */
@ApiModel(description = "订单信息查询实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchDto extends PaginationQuery {

    @ApiModelProperty(name = "id", value="订单ID（UUID）", dataType = "String", example = "1285522130867376129")
    @Length(message = "订单ID长度应为{min}位", min = 19, max = 19)
    private String id;

    @ApiModelProperty(name = "userId", value="用户ID（UUID）", dataType = "String", example = "1285759156342562818")
    @Length(message = "订单ID长度应为{min}位", min = 19, max = 19)
    private String userId;

    @ApiModelProperty(name = "title", value="订单名称", dataType = "String", example = "购买佛珠")
    private String title;

}
