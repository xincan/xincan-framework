package cn.com.xincan.xincanframework.client.order;

import cn.com.xincan.xincanframework.client.fallback.GoodsClientFallback;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
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
        name = "xincan-goods",
        path = "goods",
        fallback = GoodsClientFallback.class
)
public interface GoodsClient {

    /**
     * 根据商品ID集合，查询商品信息
     * @param ids 商品ID集合
     * @author JiangXincan
     * @date 2021/7/21 19:42
     * @return cn.com.xincan.xincanframework.utils.response.ResponseObject<java.util.List<cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo>>
     **/
    @GetMapping("/{ids}")
    ResponseObject<List<GoodsSearchVo>> findGoodsByIds(@PathVariable(name = "ids") List<String> ids);

}
