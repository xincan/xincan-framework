package cn.com.xincan.xincanframework.client.order;

import cn.com.xincan.xincanframework.client.fallback.OrderClientFallback;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 2.0.0
 * @program xincan-order-client
 * @description 订单处理客户端接口
 * @create 2021/7/20 10:10
 */
@FeignClient(
        name = "xincan-order",
        path = "order",
        fallback = OrderClientFallback.class
)
public interface OrderClient {

    /**
     * 根据用户ID查询订单信息
     * @param id 用户ID
     * @author JiangXincan
     * @date 2021/7/20 11:30
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.util.List<cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo>>
     **/
    @GetMapping("/user/{id}")
    ResponseObject<List<OrderSearchVo>> findOrderByUserId(@PathVariable(name = "id") String id);

}
