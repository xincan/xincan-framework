package cn.com.xincan.xincanframework.server.user.service;

import cn.com.xincan.xincanframework.entity.user.dto.UserPatchDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto;
import cn.com.xincan.xincanframework.entity.user.vo.UserOrderSearchVo;
import cn.com.xincan.xincanframework.entity.user.vo.UserSearchVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-user
 * 用户信息接口类
 * @create 2020/3/19 14:35
 */
public interface IUserService {

    /**
     * 根据登录名称，密码进行登录
     * @param loginName 登录名称
     * @param password 登录密码
     * @author JiangXincan
     * @date 2021/7/26 14:22
     * @return java.util.List<cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto>
     **/
    UserSearchVo findUserByParams(String loginName, String password);


    /**
     *  查询所有用户信息
     * @author Jiangxincan
     * @date 2020/7/22 9:47
     * @return java.util.List<cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto>
     */
    List<UserSearchVo> findAll();

    /**
     *  根据用户ID，查询用户详细信息实体类
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    UserOrderSearchVo findUserById(String id);

    /**
     *  根据用户ID，查询用户详细信息实体类
     * @param userSearchDto 用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<cn.com.xincan.xincanframework.entity.user.dto.UserSearchDto>
     */
    Page<UserSearchVo> page(UserSearchDto userSearchDto);

    /**
     *  根据用户ID，查询用户详细信息
     * @param saveDto 保存用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:48
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSaveDto
     */
    UserSearchVo save(UserSaveDto saveDto);

    /**
     *  修改用户信息
     * @param userPatchDto 修改用户信息实体类
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return cn.com.xincan.xincanframework.entity.user.dto.UserSearchVo
     */
    UserSearchVo patch(UserPatchDto userPatchDto);

    /**
     *  删除用户信息
     * @param id 用户ID
     * @author Jiangxincan
     * @date 2020/7/22 9:49
     * @return int
     */
    int delete(String id);

    int logout(String loginName, String password);

}
