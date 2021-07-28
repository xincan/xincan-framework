package cn.com.xincan.xincanframework.entity.user.vo;

import cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 返回用户信息试图
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "用户信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrderSearchVo  implements Serializable {

    private static final long serialVersionUID = -1032730028893181842L;

    @ApiModelProperty(name = "id", value="用户ID（UUID）", dataType = "String", example = "1285759156342562818")
    private String id;

    @ApiModelProperty(name = "name", value="用户名称", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(name = "loginName", value="用户登录名称", dataType = "String", example = "zhangsan")
    private String loginName;

    @ApiModelProperty(name = "password", value="用户登录密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(name = "phone", value="用户电话", dataType = "String", example = "18503455667")
    private String phone;

    @ApiModelProperty(name = "email", value="用户邮箱", dataType = "String", example = "alittlexincan@163.com")
    private String email;

    @ApiModelProperty(name = "address", value="用户地址", dataType = "String", example = "北京市海淀区西直门")
    private String address;

    @ApiModelProperty(name = "balance", value="用户余额", dataType = "java.math.BigDecimal", example = "10000000.01")
    private BigDecimal balance;

    @ApiModelProperty(name = "order", value="订单信息", dataType = "Object")
    private OrderGoodsSearchVo order;

}
