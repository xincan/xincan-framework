package cn.com.xincan.xincanframework.server.goods.service.impl;


import cn.com.xincan.xincanframework.entity.goods.dto.GoodsPatchDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSaveDto;
import cn.com.xincan.xincanframework.entity.goods.dto.GoodsSearchDto;
import cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.server.goods.mapper.IGoodsMapper;
import cn.com.xincan.xincanframework.server.goods.po.GoodsPo;
import cn.com.xincan.xincanframework.server.goods.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-goods
 * 商品信息接口实现类
 * @create 2020/3/19 14:36
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Resource
    private IGoodsMapper goodsMapper;

    /**
     *  根据商品ID，查询商品详细信息
     * @param ids 商品ID集合
     * @author JiangXincan
     * @date 2021/7/20 15:16
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    @Override
    public List<GoodsSearchVo> findGoodsByIds(List<String> ids) {
        LambdaQueryWrapper<GoodsPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.in(!StringUtils.isEmpty(ids), GoodsPo::getId, ids);
        List<GoodsPo> goods = goodsMapper.selectList(queryWrapper);
        return goods.stream().map( goodsPo -> OrikaUtils.map(goodsPo, GoodsSearchVo.class)).collect(Collectors.toList());
    }

    /**
     *  分页查询商品信息
     * @param goodsSearchDto 商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:18
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo>
     **/
    @Override
    public Page<GoodsSearchVo> page(GoodsSearchDto goodsSearchDto){
        Page<GoodsPo> page = new Page<>(goodsSearchDto.getPage(), goodsSearchDto.getLimit());
        LambdaQueryWrapper<GoodsPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(!StringUtils.isEmpty(goodsSearchDto.getName()), GoodsPo::getName, goodsSearchDto.getName());
        page = goodsMapper.selectPage(page, queryWrapper);
        Page<GoodsSearchVo> record = new Page<>();
        record.setRecords(OrikaUtils.mapAsList(page.getRecords(), GoodsSearchVo.class));
        record.setTotal(page.getTotal());
        return record;

    }

    /**
     *  新增商品信息
     * @param goodsSaveDto 新增商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:18
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    @Override
    public GoodsSearchVo save(GoodsSaveDto goodsSaveDto) {
        GoodsPo goods = OrikaUtils.map(goodsSaveDto, GoodsPo.class);
        goodsMapper.insert(goods);
        return OrikaUtils.map(goods, GoodsSearchVo.class);
    }

    /**
     *  修改商品信息
     * @param goodsPatchDto 修改商品信息实体类
     * @author JiangXincan
     * @date 2021/7/20 15:20
     * @return cn.com.xincan.xincanframework.entity.goods.vo.GoodsSearchVo
     **/
    @Override
    public GoodsSearchVo patch(GoodsPatchDto goodsPatchDto) {
        GoodsPo goods = OrikaUtils.map(goodsPatchDto, GoodsPo.class);
        goodsMapper.updateById(goods);
        return OrikaUtils.map(goodsPatchDto, GoodsSearchVo.class);
    }

    /**
     *  删除商品信息
     * @param id 商品ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    @Override
    public int delete(String id) {
        LambdaQueryWrapper<GoodsPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(GoodsPo::getId, id);
        return goodsMapper.delete(queryWrapper);
    }
}
