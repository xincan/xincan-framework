package cn.com.xincan.xincanframework.entity.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
 * 返回用户信息试图
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "用户信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchVo  implements Serializable {

    private static final long serialVersionUID = 8031661176694837261L;

    @ApiModelProperty(value="用户ID（UUID）", dataType = "String", example = "1285759156342562818")
    private String id;

    @ApiModelProperty(value="用户名称", dataType = "String", example = "张三")
    private String name;

    @ApiModelProperty(value="用户登录名称", dataType = "String", example = "zhangsan")
    private String loginName;

    @ApiModelProperty(value="用户登录密码", dataType = "String", example = "123456")
    private String password;

    @ApiModelProperty(value="用户电话", dataType = "String", example = "18503455667")
    private String phone;

    @ApiModelProperty(value="用户邮箱", dataType = "String", example = "alittlexincan@163.com")
    private String email;

    @ApiModelProperty(value="用户地址", dataType = "String", example = "北京市海淀区西直门")
    private String address;

    @ApiModelProperty(value="用户余额", dataType = "java.math.BigDecimal", example = "10000000.01")
    private BigDecimal balance;

    @ApiModelProperty(value="创建人员ID", dataType = "String", example = "1285759156342562818")
    private String createUserId;

    @ApiModelProperty(value="创建时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    @ApiModelProperty(value="编辑人员ID", dataType = "String", example = "1285759156342562818")
    private String editUserId;

    @ApiModelProperty(value="编辑时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime editTime;

}
