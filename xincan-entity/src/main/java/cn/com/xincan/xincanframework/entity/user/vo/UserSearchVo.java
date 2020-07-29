package cn.com.xincan.xincanframework.entity.user.vo;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 返回用户信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             0.0.1                         返回用户信息试图
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@ApiModel(description = "用户信息返回试图")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchVo {

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

    @ApiModelProperty(value="创建时间", dataType = "org.joda.time.LocalDateTime", example = "2020-12-12 23:23:23")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
