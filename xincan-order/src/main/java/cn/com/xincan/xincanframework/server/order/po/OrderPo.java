package cn.com.xincan.xincanframework.server.order.po;

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
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-order
 * 订单数据实体类
 * @create 2020/3/19 14:36
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:36             0.0.1                         订单数据实体类
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

    @TableField("title")
    private String title;

    @TableField("address")
    private String address;

    @TableField("user_id")
    private String userId;

    @TableField("description")
    private String description;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("end_time")
    private LocalDateTime endTime;

}
