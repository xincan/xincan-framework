package cn.com.xincan.xincanframework.server.order.mapper;

import cn.com.xincan.xincanframework.server.order.po.OrderPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * @description 订单数据处理接口
 * @create 2020/4/16 18:54
 */
@Mapper
public interface IOrderMapper extends BaseMapper<OrderPo> { }
