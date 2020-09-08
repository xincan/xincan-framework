package cn.com.xincan.xincanframework.entity.page;

import io.swagger.annotations.ApiModel;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @description 排序规则枚举类
 * @author JiangXincan
 * @create 2019/12/24 10:02
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * Jiangxincan         2019/12/24 10:02             1.0                         排序规则枚举类
 */
@ApiModel(description = "排序枚举类")
public enum OrderType {
    /**正序*/
    ASC,
    /**倒序*/
    DESC,
    /**不排序*/
    UNSORTED
}
