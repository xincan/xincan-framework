package cn.com.xincan.xincanframework.entity.sharding.dto;

import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class DemoSearchDto extends PaginationQuery {

    @ApiModelProperty(name = "id", value="DEMO  ID（UUID）", dataType = "String", example = "1285522130867376129")
    private String id;

    @ApiModelProperty(name = "name", value="DEMO名称", dataType = "String", example = "张三")
    private String name;

}
