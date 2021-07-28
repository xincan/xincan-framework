package cn.com.xincan.xincanframework.server.order.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 订单数据实体类
 * @create 2020/3/19 14:36
 */

@Slf4j
@Data
@TableName("`order`")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPo {

    @TableId(value = "id")
    private String id;

    @TableField("user_id")
    private String userId;

    @TableField("description")
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
