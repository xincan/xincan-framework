package cn.com.xincan.xincanframework.server.user.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 用户映射数据库表实体类
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             0.0.1                         用户映射数据库表实体类
 */
@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo {

    @TableId(value = "id")
    private String id;

    @TableField("name")
    private String name;

    @TableField("login_name")
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("phone")
    private String phone;

    @TableField("create_time")
    private LocalDateTime createTime;

}
