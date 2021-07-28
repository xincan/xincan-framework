package cn.com.xincan.xincanframework.server.goods.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-goods
 * 用户映射数据库表实体类
 * @create 2020/3/19 14:54
 */
@Data
@TableName("goods")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsPo {

    @TableId(value = "id")
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "price")
    private BigDecimal price;

    @TableField(value = "quantity")
    private Integer quantity;

    @TableField(value = "description")
    private String description;

    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "edit_user_id", fill = FieldFill.INSERT_UPDATE)
    private String editUserId;

    @TableField(value = "edit_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

}
