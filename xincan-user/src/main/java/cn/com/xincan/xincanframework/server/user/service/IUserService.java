package cn.com.xincan.xincanframework.server.user.service;

import cn.com.xincan.xincanframework.server.user.dto.UserDTO;
import cn.com.xincan.xincanframework.server.user.vo.UserVO;

import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 更新补丁接口类
 * @create 2020/3/19 14:35
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:35             1.0                         更新补丁接口类
 */
public interface IUserService {


    List<UserVO> findAll();

    UserVO findUserById(String id);

    UserVO save(UserDTO studentDTO);

}
