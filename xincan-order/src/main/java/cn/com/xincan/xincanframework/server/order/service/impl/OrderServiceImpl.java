package cn.com.xincan.xincanframework.server.order.service.impl;

import cn.com.xincan.xincanframework.common.OrikaUtils;
import cn.com.xincan.xincanframework.server.order.dto.OrderDTO;
import cn.com.xincan.xincanframework.server.order.mapper.IOrderMapper;
import cn.com.xincan.xincanframework.server.order.po.OrderPO;
import cn.com.xincan.xincanframework.server.order.service.IOrderService;
import cn.com.xincan.xincanframework.server.order.vo.OrderVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * 更新补丁接口实现类
 * @create 2020/3/19 14:36
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:36             1.0                         更新补丁接口实现类
 */
@Component
public class OrderServiceImpl implements IOrderService {


    @Resource
    private IOrderMapper orderMapper;

    @Override
    public List<OrderVO> findAll() {
        List<OrderPO> lists =  orderMapper.selectList(null);
        return OrikaUtils.mapAsList(lists, OrderVO.class);

    }

    @Override
    public OrderVO findUserById(String id) {
        OrderPO user = orderMapper.selectById(id);
        return OrikaUtils.map(user, OrderVO.class);
    }

    @Override
    public OrderVO save(OrderDTO userDTO) {
        OrderPO user = OrikaUtils.map(userDTO, OrderPO.class);
        orderMapper.insert(user);
        return OrikaUtils.map(user, OrderVO.class);
    }
}
