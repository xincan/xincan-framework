package cn.com.xincan.xincanframework.server.user.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-user
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         系统更新信息试图
 */

@Slf4j
@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPO {

    @TableId(value = "id")
    private String id;

    @TableField("name")
    private String name;

}
