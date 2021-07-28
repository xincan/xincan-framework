package cn.com.xincan.xincanframework.config.datasource;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description 数据源管理（设置路由的目的为了方便查找对应的数据源，我们可以用ThreadLocal保存数据源的信息到每个线程中，方便我们需要时获取）
 * @create 2020/7/31 16:42
 */
@Slf4j
public class DataSourceContextHolder {

     /**
       *  创建线程
       * @author Jiangxincan
       * @date 2020/7/31 16:45
       */
    private static final ThreadLocal<DynamicDataSourceEnum> DYNAMIC_DATASOURCE_CONTEXT = new ThreadLocal<>();

    private static final AtomicInteger COUNTER = new AtomicInteger(-1);

    private static final int CHANGE_DATASOURCE_NUMBER = 9999;

    /**
     *  将数据库类型存入线程
     * @param datasourceType 数据库类型
     * @author Jiangxincan
     * @date 2020/7/31 16:46
     */
    public static void set(DynamicDataSourceEnum datasourceType) {
        DYNAMIC_DATASOURCE_CONTEXT.set(datasourceType);
        log.info("切换数据源为：{}", datasourceType);
    }

    /**
     *  从线程中获取数据源
     * @author Jiangxincan
     * @date 2020/7/31 16:46
     */
    public static DynamicDataSourceEnum get() {
        return DYNAMIC_DATASOURCE_CONTEXT.get();
    }

    /**
     *  设置主数据源
     * @author Jiangxincan
     * @date 2020/7/31 17:33
     * @return void
     */
    public static void master() {
        set(DynamicDataSourceEnum.MASTER);
    }

    /**
     *  从数据源轮询
     *
     * @author Jiangxincan
     * @date 2020/7/31 17:33
     */
    public static void slave() {
        int index = COUNTER.getAndIncrement() % 2;
        if (COUNTER.get() > CHANGE_DATASOURCE_NUMBER) {
            COUNTER.set(-1);
        }
        if (index == 0) {
            set(DynamicDataSourceEnum.SLAVE1);
        } else {
            set(DynamicDataSourceEnum.SLAVE2);
        }
    }

    /**
     *  从线程中清除数据源
     * @author Jiangxincan
     * @date 2020/7/31 16:46
     */
    public static void clear() {
        DYNAMIC_DATASOURCE_CONTEXT.remove();
    }

}
