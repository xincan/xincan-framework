package cn.com.xincan.xincanframework.client.fallback;

import cn.com.xincan.xincanframework.client.order.OrderClient;
import cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import cn.com.xincan.xincanframework.utils.response.ResponseResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 2.0.0
 * @program xincan-framework
 * @description 订单降级处理类
 * @create 2021/7/20 10:13
 */
@Component
public class OrderClientFallback implements OrderClient {

    /**
     * 根据用户ID查询订单信息
     * 降级处理
     * @param id 用户ID
     * @author JiangXincan
     * @date 2021/7/20 11:30
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.util.List<cn.com.xincan.xincanframework.entity.order.vo.OrderSearchVo>>
     **/
    @Override
    public ResponseObject<List<OrderSearchVo>> findOrderByUserId(String id) {
        return ResponseResult.error(ResponseCode.REQUEST_SERVICE_ERROR);
    }
}
