package cn.com.xincan.xincanframework.config.log;

import java.lang.annotation.*;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/9/22 11:31             1.0                         rizh
 * @program xincan-framework
 * @description rizh
 * @create 2020/9/22 11:31
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptionLog {
    /**
     * 要执行的操作类型（比如：add操作）
     */
    String type() default LogType.BUSINESS_OPERATION;

    /**
     * 要执行的具体操作类型（比如：添加用户）
     */
    String description() default "";

}
