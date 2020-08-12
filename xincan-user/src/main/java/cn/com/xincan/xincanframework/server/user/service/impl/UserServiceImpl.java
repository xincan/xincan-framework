package cn.com.xincan.xincanframework.server.user.service.impl;

import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import cn.com.xincan.xincanframework.server.user.mapper.IUserMapper;
import cn.com.xincan.xincanframework.server.user.po.UserPo;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.utils.common.orika.OrikaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息接口实现类
 * @create 2020/3/19 14:36
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:36             0.0.1                         用户信息接口实现类
 */
@Service
public class UserServiceImpl implements IUserService {


    @Resource
    private IUserMapper userMapper;

    /**
     *  查询所有用户信息
     * @author JiangXincan
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
     * @date 2020/7/22 9:48
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    @Override
    public UserSearchVo findUserById(String id) {
        UserPo user = userMapper.selectById(id);
        return OrikaUtils.map(user, UserSearchVo.class);
    }

    /**
     *  新增用户信息
     * @param userSaveDto 新增用户信息实体类
     * @author JiangXincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    @Override
    public UserSearchVo save(UserSaveDto userSaveDto) {
        UserPo user = OrikaUtils.map(userSaveDto, UserPo.class);
        userMapper.insert(user);
        return OrikaUtils.map(user, UserSearchVo.class);
    }
}
