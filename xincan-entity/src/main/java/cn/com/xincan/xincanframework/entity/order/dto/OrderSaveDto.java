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

    @ApiModelProperty(value="订单名称", required = true, dataType = "String", example = "购买佛珠")
    @NotBlank(message = "订单名称不能为空")
    private String title;

    @ApiModelProperty(value="订单地址（收货地址）", required = true, dataType = "String", example = "北京市房山区")
    @NotBlank(message = "订单地址不能为空")
    private String address;

    @ApiModelProperty(value="订单人ID（收货人ID、UUID）", required = true, dataType = "String", example = "1285759156342562818")
    @Length(message = "订单人ID长度应为{min}位", min = 19, max = 19)
    @NotBlank(message = "订单人ID不能为空")
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
