package cn.com.xincan.xincanframework.server.user.service;

import cn.com.xincan.xincanframework.server.user.dto.UserSaveDto;
import cn.com.xincan.xincanframework.server.user.vo.UserSearchVo;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 用户信息接口类
 * @create 2020/3/19 14:35
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:35             1.0                         用户信息接口类
 */
public interface IUserService {


    List<UserSearchVo> findAll();

    UserSearchVo findUserById(String id);

    UserSearchVo save(UserSaveDto userSaveDto);

}
