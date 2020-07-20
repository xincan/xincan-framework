package cn.com.xincan.xincanframework.server.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 用户查询实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         用户查询实体类
 */
@ApiModel(description = "用户参数实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @ApiModelProperty(value="用户ID", dataType = "String", hidden = true, example = "UUID")
    private String id;

    @ApiModelProperty(value="用户名称", dataType = "String", example = "张三")
    private String name;

}
