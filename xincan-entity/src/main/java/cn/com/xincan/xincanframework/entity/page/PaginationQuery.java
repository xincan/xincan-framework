package cn.com.xincan.xincanframework.entity.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program xincan-framework
 * @description 分页查询公用处理类
 * @author Jiangxincan
 * @create 2020/09/07 13:15
 * @version 1.0
 */
@Data
@SuperBuilder
@ApiModel(description = "分页查询公用处理类")
@AllArgsConstructor
@NoArgsConstructor
public class PaginationQuery implements Serializable {

    private static final long serialVersionUID = 6599955257806082717L;

    @ApiModelProperty(value="当前页数,为空时，默认从第1页开始", dataType = "Integer", example = "1")
    @DecimalMin(message = "当前页数错误,应当大于等于于{value}一页", value = "1")
    public Integer page = 1;

    @ApiModelProperty(value="每页条数，为空时，默认每页提供10条数据", dataType = "Integer", example = "10")
    @DecimalMin(message = "每页条数错误,应当大于等于于{value}条", value = "1")
    public Integer limit = 10;

    @ApiModelProperty(name="sortName",value="排序字段名称", dataType = "String")
    public String sortName;

    @ApiModelProperty(name="sortOrder",value="排序规则(ASC,DESC)，默认DESC", dataType = "OrderType", example = "DESC")
    public OrderType sortOrder;

    public PaginationQuery(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public PaginationQuery(String sortName, OrderType sortOrder) {
        this.sortName = sortName;
        this.sortOrder = sortOrder;
    }

}
