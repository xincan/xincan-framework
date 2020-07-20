package cn.com.xincan.xincanframework.server.order.vo;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         系统更新信息试图
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "订单信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVO {

    @ApiModelProperty(value="订单ID", dataType = "String", example = "UUID")
    private String id;

    @ApiModelProperty(value="订单名称", dataType = "String", example = "张三")
    private String name;

}
