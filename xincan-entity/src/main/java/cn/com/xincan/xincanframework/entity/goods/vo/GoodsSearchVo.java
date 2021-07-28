package cn.com.xincan.xincanframework.entity.goods.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 返回商品信息试图
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "商品信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsSearchVo  implements Serializable {

    private static final long serialVersionUID = 4906258668699699287L;

    @ApiModelProperty(value="商品ID（UUID）", dataType = "String", example = "1285759156342562818")
    private String id;

    @ApiModelProperty(value="商品名称", dataType = "String", example = "佛珠")
    private String name;

    @ApiModelProperty(value="商品价格", dataType = "java.math.BigDecimal", example = "10000000.01")
    private BigDecimal price;

    @ApiModelProperty(value="商品库存个数", dataType = "Integer", example = "3")
    private Integer quantity;

    @ApiModelProperty(value="商品描述", dataType = "String", example = "佛珠用途描述")
    private String description;

    @ApiModelProperty(value="创建人员ID", dataType = "String", example = "1285759156342562818")
    private String createUserId;

    @ApiModelProperty(value="创建时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "1285759156342562818")
    private String editUserId;

    @ApiModelProperty(value="编辑时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime editTime;

}
