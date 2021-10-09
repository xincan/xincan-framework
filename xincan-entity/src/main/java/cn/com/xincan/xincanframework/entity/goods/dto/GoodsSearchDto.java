package cn.com.xincan.xincanframework.entity.goods.dto;

import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 商品信息查询参数实体类
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "商品信息查询参数实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class GoodsSearchDto extends PaginationQuery  implements Serializable {

    private static final long serialVersionUID = 2828040451224616984L;

    @ApiModelProperty(value="商品ID", dataType = "String", required = true, example = "1285759156342562818")
    @NotNull(message = "商品ID不能为空")
    @Length(message = "商品ID长度应为{min}位", min = 19, max = 19)
    private String id;

    @ApiModelProperty(value="商品名称", dataType = "String", example = "佛珠")
    @Length(message = "商品名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String name;

    @ApiModelProperty(value="商品价格", dataType = "java.math.BigDecimal", example = "10000000.01")
    private BigDecimal price;

}
