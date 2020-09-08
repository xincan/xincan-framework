package cn.com.xincan.xincanframework.server.user.mapper;

import cn.com.xincan.xincanframework.server.user.po.UserPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-user
 * @description 用户数据处理接口
 * @create 2020/4/16 18:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/4/16 18:54             0.0.1                         用户数据处理接口
 */
public interface IUserMapper extends BaseMapper<UserPo> {
}
