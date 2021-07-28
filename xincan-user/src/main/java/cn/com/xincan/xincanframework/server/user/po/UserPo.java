package cn.com.xincan.xincanframework.server.user.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户映射数据库表实体类
 * @create 2020/3/19 14:54
 */
@Data
@RedisHash("user")
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPo implements Serializable {

    private static final long serialVersionUID = 5772284552932872042L;

    @Id
    @TableId(value = "id")
    private String id;

    @TableField(value = "name")
    private String name;

    @Indexed
    @TableField(value = "login_name")
    private String loginName;

    @Indexed
    @TableField(value = "password")
    private String password;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "address")
    private String address;

    @TableField(value = "balance")
    private BigDecimal balance;

    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "edit_user_id", fill = FieldFill.INSERT_UPDATE)
    private String editUserId;

    @TableField(value = "edit_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

}
