package cn.com.xincan.xincanframework.utils.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-framework
 * @description 总体配置信息实体类
 * @create 2020/7/20 15:44
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/20 15:44             0.0.1                         总体配置信息实体类
 */
@ApiModel(description = "邮箱实体类")
@Component
public class Email {

    @ApiModelProperty(value="邮箱地址", dataType = "String", example = "alittlexincan@163.com")
    private String address;

    @ApiModelProperty(value="登录密码", dataType = "String", example = "******")
    private String password;

    public Email() {}

    public Email(String address, String password) {
        this.address = address;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
