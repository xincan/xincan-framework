package cn.com.xincan.xincanframework.config.log;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework-entity-starter
 * 系统日志DTO
 * @author WangMingShuai
 * @create 2019/12/20 17:03
 * @version 2.0.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/20 17:03             2.0.0                         系统日志DTO
 */
@ApiModel( description = "系统日志DTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemLogSaveDTO {

    @ApiModelProperty(value="当前系统操作用户ID", dataType = "String", required = true, example = "UUID")
    private String userId;

    @ApiModelProperty(value="当前系统操作用户名称", dataType = "String", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value="当前系统操作用户账号", dataType = "String", required = true, example = "张三")
    private String username;

    @ApiModelProperty(value="当前系统操作租户ID", dataType = "String", required = true, example = "UUID")
    private String tenantId;

    @ApiModelProperty(value="当前系统操作用户所在部门名称", dataType = "String", required = true, example = "视觉交互部")
    private String organizationId;

    @ApiModelProperty(value="当前系统操作主机IP", dataType = "String", required = true, example = "192.168.1.1")
    private String ip;

    @ApiModelProperty(value="当前系统操作微服务端口", dataType = "Integer", required = true, example = "99999")
    private Integer port;

    @ApiModelProperty(value="当前系统微服务名称", dataType = "String", required = true, example = "xincan-transaction-user")
    private String microService;

    @ApiModelProperty(value="当前系统请求微服务方法函数路径", dataType = "String", required = true, example = "http://192.168.1.1:8080/user/find")
    private String classUrl;

    @ApiModelProperty(value="当前系统类请求微服务方法函数参数", dataType = "String", required = true, example = "[{\"name\":\"lisi\"}]")
    private String classParam;

    @ApiModelProperty(value="当前系统操作类型", dataType = "String", required = true, example = "登录日志")
    private String type;

    @ApiModelProperty(value="菜单id", dataType = "String", required = true, example = "菜单ID")
    private String menuId;

    @ApiModelProperty(value="操作id", dataType = "String", required = true, example = "操作ID")
    private String operationId;

    @ApiModelProperty(value="服务类型(0:客户端调用, 1:内部服务间调用)", dataType = "Integer", required = true, example = "0")
    private Integer serviceType;

    @ApiModelProperty(value="当前系统操作说明", dataType = "String", example = "调用接口做实现")
    private String description;

}
