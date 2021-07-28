package cn.com.xincan.xincanframework.utils.response;

import java.lang.annotation.*;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 返回值处理注解：指定具体某个controller中某个函数不需要进行结果包装，也就是排除ResponseResult结果封装类中的属性，以原有值作为返回值
 * @create 2020/10/9 10:45
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseNotPackResultBody {
}
