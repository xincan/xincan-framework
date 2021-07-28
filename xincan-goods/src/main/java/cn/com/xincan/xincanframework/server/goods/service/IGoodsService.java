package cn.com.xincan.xincanframework.server.goods.service;

import cn.com.xincan.xincanframework.entity.goods.dto.GoodsPatchDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSaveDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSearchDto;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-goods
 * 商品信息接口类
 * @create 2020/3/19 14:35
 */
public interface IGoodsService {

    /**
     *  根据商品ID，查询商品详细信息实体类
     * @param ids 商品ID集合
     * @author JiangXincan
     * @date 2021/7/20 15:13
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    List<GoodsSearchVo> findGoodsByIds(List<String> ids);

    /**
     *  根据商品ID，查询商品详细信息实体类
     * @param goodsSearchDto 商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:14
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo>
     **/
    Page<GoodsSearchVo> page(GoodsSearchDto goodsSearchDto);

    /**
     *  根据商品ID，查询商品详细信息
     * @param goodsSaveDto 保存商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:15
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    GoodsSearchVo save(GoodsSaveDto goodsSaveDto);

    /**
     *  修改商品信息
     * @param goodsPatchDto 修改商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:15
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    GoodsSearchVo patch(GoodsPatchDto goodsPatchDto);

    /**
     *  删除商品信息
     * @param id 商品ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    int delete(String id);

}
