package cn.com.xincan.xincanframework.server.user.mapper;

import cn.com.xincan.xincanframework.server.user.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * @description 用户数据处理接口
 * @create 2020/4/16 18:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/4/16 18:54             1.0                         用户数据处理接口
 */
@Mapper
public interface IUserMapper extends BaseMapper<UserPO> { }
