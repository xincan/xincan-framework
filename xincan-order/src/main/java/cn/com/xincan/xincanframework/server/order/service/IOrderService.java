package cn.com.xincan.xincanframework.server.order.service;

import cn.com.xincan.xincanframework.server.order.dto.OrderDTO;
import cn.com.xincan.xincanframework.server.order.vo.OrderVO;

import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * 更新补丁接口类
 * @create 2020/3/19 14:35
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:35             1.0                         更新补丁接口类
 */
public interface IOrderService {


    List<OrderVO> findAll();

    OrderVO findUserById(String id);

    OrderVO save(OrderDTO studentDTO);

}
