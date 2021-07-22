package cn.com.xincan.xincanframework.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author Jiangxincan
 * @version 1.0
 * @program xincan-framework
 * @description 数据源配置
 * @create 2020/7/31 16:32
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    /**
     *  主数据源
     * @author Jiangxincan
     * @date 2020/7/31 16:34
     * @return javax.sql.DataSource
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource master() {
        log.info("init master");
        return new HikariDataSource();
    }

    /**
     *  从数据源 slave1
     * @author Jiangxincan
     * @date 2020/7/31 16:34
     * @return javax.sql.DataSource
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    @ConditionalOnProperty(prefix = "spring.datasource", name = "slave1", matchIfMissing = true)
    public DataSource slave1() {
        log.info("init slave1");
        return new HikariDataSource();
    }

    /**
     *  从数据源 slave2
     * @author Jiangxincan
     * @date 2020/7/31 16:34
     * @return javax.sql.DataSource
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    @ConditionalOnProperty(prefix = "spring.datasource", name = "slave2", matchIfMissing = true)
    public DataSource slave2() {
        log.info("init slave2");
        return new HikariDataSource();
    }

    /**
     *  这里，我们配置了4个数据源，1个master，2两个slave，1个路由数据源。前3个数据源都是为了生成第4个数据源，而且后续我们只用这最后一个路由数据源。
     * @param masterDataSource  主数据源 master
     * @param slave1DataSource  从数据源 slave1
     * @param slave2DataSource  从数据源 slave2
     * @author Jiangxincan
     * @date 2020/7/31 17:13
     * @return javax.sql.DataSource
     */
    @Bean
    public DataSource routingDataSource(
            @Qualifier("master") DataSource masterDataSource,
            @Qualifier("slave1") DataSource slave1DataSource,
            @Qualifier("slave2") DataSource slave2DataSource
    ) {
        log.info("create routingDataSource");
        Map<Object, Object> targetDataSource = new HashMap<>(3);
        targetDataSource.put(DynamicDataSourceEnum.MASTER, masterDataSource);
        targetDataSource.put(DynamicDataSourceEnum.SLAVE1, slave1DataSource);
        targetDataSource.put(DynamicDataSourceEnum.SLAVE2, slave2DataSource);
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        dynamicRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicRoutingDataSource.setTargetDataSources(targetDataSource);
        return dynamicRoutingDataSource;
    }

}
