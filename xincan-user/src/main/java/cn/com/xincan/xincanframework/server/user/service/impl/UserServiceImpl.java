package cn.com.xincan.xincanframework.server.user.service.impl;

import cn.com.xincan.xincanframework.client.order.OrderClient;
import cn.com.xincan.xincanframework.config.excetion.UserException;
import cn.com.xincan.xincanframework.entity.order.vo.OrderGoodsSearchVo;
import cn.com.xincan.xincanframework.entity.user.dto.UserPatchDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserOrderSearchVo;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.server.user.mapper.IUserMapper;
import cn.com.xincan.xincanframework.server.user.po.UserPo;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.orika.OrikaUtils;
import cn.com.xincan.xincanframework.utils.response.ResponseCode;
import cn.com.xincan.xincanframework.utils.response.ResponseObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息接口实现类
 * @create 2020/3/19 14:36
 */
@Service
public class UserServiceImpl implements IUserService {


    @Resource
    private IUserMapper userMapper;

    private final OrderClient orderClient;

    public UserServiceImpl(OrderClient orderClient) {
        this.orderClient = orderClient;
    }


    /**
     * 根据登录名称，密码进行登录
     * @param loginName 登录名称
     * @param password 登录密码
     * @author JiangXincan
     * @date 2021/7/26 14:22
     * @return java.util.List<cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto>
     **/
    @Cacheable(cacheNames = "user", key = "#loginName")
    @Override
    public UserSearchVo findUserByParams(String loginName, String password) {
        LambdaQueryWrapper<UserPo> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserPo::getLoginName, loginName).eq(UserPo::getPassword, password);
        UserPo userPo = userMapper.selectOne(queryWrapper);
        return OrikaUtils.map(userPo, UserSearchVo.class);
    }

    /**
     *  查询所有用户信息
     * @author Jiangxincan
     * @date 2020/7/22 9:47
     * @return java.util.List<cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto>
     */
    @Override
    public List<UserSearchVo> findAll() {
        List<UserPo> lists =  userMapper.selectList(null);
        return OrikaUtils.mapAsList(lists, UserSearchVo.class);

    }

    /**
     *  根据用户ID，查询用户详细信息
     * @param id 用户ID
     * @author JiangXincan
     * @date 2021/7/20 11:25
     * @return cn.com.xincan.xincanframework.entity.user.vo.UserOrderSearchVo
     **/
    @Override
    public UserOrderSearchVo findUserById(String id) {
        ResponseObject<OrderGoodsSearchVo> ordersResult = orderClient.findOrderByUserId(id);
        if (ordersResult.getCode() == ResponseCode.REQUEST_SERVICE_ERROR.code()) {
            throw new UserException(ordersResult.getCode(), ordersResult.getMsg());
        }
         UserPo user = userMapper.selectById(id);
        UserOrderSearchVo userOrderSearchVo = OrikaUtils.map(user, UserOrderSearchVo.class);
        userOrderSearchVo.setOrder(ordersResult.getData());
        return userOrderSearchVo;
    }

    /**
     *  分页查询用户信息
     * @param userSearchDto 用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto>
     */
    @Override
    public Page<UserSearchVo> page(UserSearchDto userSearchDto){
        Page<UserPo> page = new Page<>(userSearchDto.getPage(), userSearchDto.getLimit());
        LambdaQueryWrapper<UserPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userSearchDto.getLoginName()), UserPo::getLoginName, userSearchDto.getLoginName());
        page = userMapper.selectPage(page, queryWrapper);
        Page<UserSearchVo> record = new Page<>();
        record.setRecords(OrikaUtils.mapAsList(page.getRecords(), UserSearchVo.class));
        record.setTotal(page.getTotal());
        return record;

    }

    /**
     *  新增用户信息
     * @param userSaveDto 新增用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    @Override
    public UserSearchVo save(UserSaveDto userSaveDto) {
        UserPo user = OrikaUtils.map(userSaveDto, UserPo.class);
        userMapper.insert(user);
        return OrikaUtils.map(user, UserSearchVo.class);
    }

    /**
     *  修改用户信息
     * @param userPatchDto 修改用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSearchVo
     */
    @Override
    public UserSearchVo patch(UserPatchDto userPatchDto) {
        UserPo userPo = OrikaUtils.map(userPatchDto, UserPo.class);
        userMapper.updateById(userPo);
        return OrikaUtils.map(userPatchDto, UserSearchVo.class);
    }

    /**
     *  删除用户信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    @Override
    public int delete(String id) {
        LambdaQueryWrapper<UserPo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserPo::getId, id);
        return userMapper.delete(queryWrapper);
    }

    /**
     * 用户退出登录
     * @param loginName 登录名称
     * @param password  登录密码
     * @author JiangXincan
     * @date 2021/7/26 17:44
     * @return int
     **/
    @CacheEvict(cacheNames = "user", key = "#loginName")
    @Override
    public int logout(String loginName, String password) {
        return 1;
    }
}
