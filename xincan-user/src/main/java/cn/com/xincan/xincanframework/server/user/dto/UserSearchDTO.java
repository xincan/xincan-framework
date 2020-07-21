package cn.com.xincan.xincanframework.server.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         系统更新信息试图
 */
@ApiModel(description = "用户信息查询参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchDTO {

    @ApiModelProperty(value="用户ID", dataType = "String", required = true, example = "UUID")
    private String id;

    @ApiModelProperty(value="用户名称", dataType = "String", example = "张三")
    private String name;

}
