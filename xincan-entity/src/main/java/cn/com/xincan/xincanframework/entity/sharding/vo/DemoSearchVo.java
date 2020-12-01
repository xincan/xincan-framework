package cn.com.xincan.xincanframework.entity.sharding.vo;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:54             0.0.1                         系统更新信息试图
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(description = "订单信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DemoSearchVo {

    @ApiModelProperty(name="id", value="DEMO ID（UUID）", dataType = "String", hidden = true, example = "1285522130867376129")
    private String id;

    @ApiModelProperty(name="title", value="DEMO 名称", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(name = "loginName", value="登录地址（收货地址）", dataType = "String", example = "zhangsan")
    private String loginName;

    @ApiModelProperty(name = "password", value="登录密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(name = "phone", value="电话号码", dataType = "String", example = "18512343456")
    private String phone;

    @ApiModelProperty(name = "createTime", value="创建时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
