package cn.com.xincan.xincanframework.server.user.service;

import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息接口类
 * @create 2020/3/19 14:35
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:35             0.0.1                         用户信息接口类
 */
public interface IUserService {


    /**
     *  查询所有用户信息
     * @author JiangXincan
     * @date 2020/7/22 9:47
     * @return java.util.List<cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto>
     */
    List<UserSearchVo> findAll();

    /**
     *  根据用户ID，查询用户详细信息
     * @param id 用户ID
     * @author JiangXincan
     * @date 2020/7/22 9:48
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    UserSearchVo findUserById(String id);

    /**
     *  新增用户信息
     * @param userSaveDto 新增用户信息实体类
     * @author JiangXincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    UserSearchVo save(UserSaveDto userSaveDto);

}
