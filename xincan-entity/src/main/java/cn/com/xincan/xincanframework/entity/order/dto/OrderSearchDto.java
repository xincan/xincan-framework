package cn.com.xincan.xincanframework.entity.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-order
 * 订单信息查询实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             0.0.1                       订单信息查询实体类
 */
@ApiModel(description = "订单信息查询实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSearchDto {

    @ApiModelProperty(name = "id", value="订单ID（UUID）", dataType = "String", example = "1285522130867376129")
    private String id;

    @ApiModelProperty(name = "userId", value="用户ID（UUID）", dataType = "String", example = "1285759156342562818")
    private String userId;

    @ApiModelProperty(name = "title", value="订单名称", dataType = "String", example = "购买佛珠")
    private String title;

}
