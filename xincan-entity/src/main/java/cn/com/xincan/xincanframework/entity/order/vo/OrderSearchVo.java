package cn.com.xincan.xincanframework.entity.order.vo;

import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 */

@ApiModel(description = "订单信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSearchVo implements Serializable {

    private static final long serialVersionUID = 7316244809230564570L;

    @ApiModelProperty(name="id", value="订单ID（UUID）", dataType = "String", hidden = true, example = "1285522130867376129")
    private String id;

    @ApiModelProperty(name="user", value="用户信息", dataType = "cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo")
    private UserSearchVo user;

    @ApiModelProperty(name = "goods", value="订单地址（收货地址）", dataType = "java.util.List<cn.com.xincan.xincanframework.entity.goods.dto.GoodsSearchDto>")
    private List<GoodsSearchVo> goods;

    @ApiModelProperty(value="订单说明（附加信息）", dataType = "String", example = "注意物件不能轻易碰撞")
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
