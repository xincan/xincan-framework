package cn.com.xincan.xincanframework.entity.user.dto;

import cn.com.xincan.xincanframework.entity.page.OrderType;
import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息查询参数实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/3/19 14:54             0.0.1                         用户信息查询参数实体类
 */
@ApiModel(description = "用户信息查询参数实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDto extends PaginationQuery {

    @ApiModelProperty(value="用户ID（UUID）", dataType = "String", example = "1285759156342562818")
    @Length(message = "用户ID长度应为32位", min = 32, max = 32)
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
