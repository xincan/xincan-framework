package cn.com.xincan.xincanframework.server.order.dto;

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
 * @version 1.0
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         系统更新信息试图
 */
@ApiModel(description = "订单信息查询实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSearchDto {

    @ApiModelProperty(value="订单ID", dataType = "String", example = "1285522130867376129")
    private String id;

    @ApiModelProperty(value="用户ID", dataType = "String", example = "1285522130867376129")
    private String userId;

    @ApiModelProperty(value="订单名称", dataType = "String", example = "购买佛珠")
    private String title;

}
