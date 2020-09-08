package cn.com.xincan.xincanframework.entity.user.dto;

import cn.com.xincan.xincanframework.entity.page.OrderType;
import cn.com.xincan.xincanframework.entity.page.PaginationQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息查询参数实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             0.0.1                         用户信息查询参数实体类
 */
@ApiModel(description = "用户信息查询参数实体类")
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserSearchDto extends PaginationQuery {

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

    public UserSearchDto(){super();}

    public UserSearchDto(@NotNull(message = "当前页数不能为空") @DecimalMin(message = "当前页数错误,应当大于等于于{value}一页", value = "1") Integer page, @NotNull(message = "每页条数不能为空") @DecimalMin(message = "每页条数错误,应当大于等于于{value}条", value = "1") Integer limit, String sortName, OrderType sortOrder, String id, String name, String loginName, String password, String phone, LocalDateTime createTime) {
        super(page, limit, sortName, sortOrder);
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.phone = phone;
        this.createTime = createTime;
    }

}
