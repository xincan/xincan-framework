package cn.com.xincan.xincanframework.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Nullable;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description 数据源路由处理
 * @create 2020/7/31 16:40
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    /**
     *  根据key查找对应的数据源
     *  AbstractRoutingDataSource的作用是基于查找key路由到对应的数据源，它内部维护了一组目标数据源，并且做了路由key与目标数据源之间的映射，提供基于key查找数据源的方法
     * @author Jiangxincan
     * @date 2020/7/31 16:50
     * @return java.lang.Object
     */
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}
