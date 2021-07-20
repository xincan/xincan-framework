package cn.com.xincan.xincanframework.server.goods.mapper;

import cn.com.xincan.xincanframework.server.goods.po.GoodsPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-goods
 * @description 商品数据处理接口
 * @create 2020/4/16 18:54
 */
@Repository
public interface IGoodsMapper extends BaseMapper<GoodsPo> {
}
