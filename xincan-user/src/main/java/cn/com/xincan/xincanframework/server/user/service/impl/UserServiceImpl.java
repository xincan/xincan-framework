package cn.com.xincan.xincanframework.server.user.service.impl;

import cn.com.xincan.xincanframework.common.OrikaUtils;
import cn.com.xincan.xincanframework.server.user.dto.UserDTO;
import cn.com.xincan.xincanframework.server.user.mapper.IUserMapper;
import cn.com.xincan.xincanframework.server.user.po.UserPO;
import cn.com.xincan.xincanframework.server.user.service.IUserService;
import cn.com.xincan.xincanframework.server.user.vo.UserVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 更新补丁接口实现类
 * @create 2020/3/19 14:36
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:36             1.0                         更新补丁接口实现类
 */
@Component
public class UserServiceImpl implements IUserService {


    @Resource
    private IUserMapper studentMapper;

    @Override
    public List<UserVO> findAll() {
        List<UserPO> lists =  studentMapper.selectList(null);
        return OrikaUtils.mapAsList(lists, UserVO.class);

    }

    @Override
    public UserVO findUserById(String id) {
        UserPO user = studentMapper.selectById(id);
        return OrikaUtils.map(user, UserVO.class);
    }

    @Override
    public UserVO save(UserDTO userDTO) {
        UserPO user = OrikaUtils.map(userDTO, UserPO.class);
        studentMapper.insert(user);
        return OrikaUtils.map(user, UserVO.class);
    }
}
