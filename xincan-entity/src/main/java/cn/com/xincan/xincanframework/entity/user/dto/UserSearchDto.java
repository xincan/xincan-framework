package cn.com.xincan.xincanframework.entity.user.dto;

import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import java.io.Serializable;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息查询参数实体类
 * @create 2020/3/19 14:54
 */
@ApiModel(description = "用户信息查询参数实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDto extends PaginationQuery  implements Serializable {

    private static final long serialVersionUID = 8284188496912642018L;

    @ApiModelProperty(value="用户ID", dataType = "String", required = true, example = "1285759156342562818")
    @Length(message = "用户ID长度应为{min}位", min = 19, max = 19)
    private String id;

    @ApiModelProperty(value="用户名称", dataType = "String", required = true, example = "张三")
    @Length(message = "用户名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String name;

    @ApiModelProperty(value="用户登录名称", dataType = "String", required = true, example = "zhangsan")
    @Length(message = "登录名称长度应在{min}~{max}之间", min = 1, max = 50)
    private String loginName;

    @ApiModelProperty(value="登录密码", dataType = "String", required = true, example = "123456")
    @Length(message = "登录密码长度应在{min}~{max}之间", min = 6, max = 20)
    private String password;

    @ApiModelProperty(value="用户电话", dataType = "String", example = "18503455667")
    @Length(message = "用户电话长度应为{min}位", min = 11, max = 11)
    private String phone;

    @ApiModelProperty(value="用户邮箱", dataType = "String", example = "alittlexincan@163.com")
    @Length(message = "用户邮箱长度应为{min}位", min = 10, max = 50)
    private String email;


}
