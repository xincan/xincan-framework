package cn.com.xincan.xincanframework.entity.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiModelProperty(value="订单名称", dataType = "String", example = "购买佛珠")
    private String title;

    @ApiModelProperty(value="订单地址（收货地址）", dataType = "String", example = "北京市房山区")
    private String address;

    @ApiModelProperty(value="订单人ID（收货人ID、UUID）", dataType = "String", example = "1285759156342562818")
    private String userId;

    @ApiModelProperty(value="订单说明（附加信息）", dataType = "String", example = "注意物件不能轻易碰撞")
    private String description;

    @ApiModelProperty(value="订单时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value="收货时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

}
