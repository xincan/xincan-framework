package cn.com.xincan.xincanframework.server.order.mapper;

import cn.com.xincan.xincanframework.server.order.po.OrderPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * @description 订单数据处理接口
 * @create 2020/4/16 18:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/4/16 18:54             1.0                         订单数据处理接口
 */
@Mapper
public interface IOrderMapper extends BaseMapper<OrderPO> { }
