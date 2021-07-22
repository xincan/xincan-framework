package cn.com.xincan.xincanframework.entity.goods.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 商品保存参数实体类
 * @create 2020/7/22 9:39
 */
@ApiModel(description = "保存商品信息参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsSaveDto  implements Serializable {

    private static final long serialVersionUID = 3008862556084344058L;

    @ApiModelProperty(value="商品名称", dataType = "String", example = "佛珠")
    @Length(message = "商品名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String name;

    @ApiModelProperty(value="商品价格", dataType = "java.math.BigDecimal", example = "10000000.01")
    private BigDecimal price;

    @ApiModelProperty(value="商品库存个数", dataType = "Integer", example = "3")
    @Max(message = "商品库存个数最大为{value}", value = 999999999)
    @Min(message = "商品库存个数最小为{value}", value = 0)
    private Integer quantity;

    @ApiModelProperty(value="商品描述", dataType = "String", example = "佛珠用途描述")
    @Length(message = "商品描述长度应在{min}~{max}之间", min = 0, max = 500)
    private String description;

}
