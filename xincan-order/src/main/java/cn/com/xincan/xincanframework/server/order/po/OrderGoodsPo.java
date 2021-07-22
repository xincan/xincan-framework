package cn.com.xincan.xincanframework.server.order.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


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
@TableName("order_goods")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderGoodsPo {

    @TableId(value = "order_id")
    private String orderId;

    @TableId(value = "goods_id")
    private String goodsId;

    @TableId(value = "user_id")
    private String userId;



}
