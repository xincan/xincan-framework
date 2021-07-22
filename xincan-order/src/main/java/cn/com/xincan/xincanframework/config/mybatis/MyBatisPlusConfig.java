package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 * MyBatisPlus 配置
 * @author Jiangxincan
 * @create 2019/12/20 15:27
 * @version 0.0.1
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.com.xincan.xincanframework.server.*.mapper")
public class MyBatisPlusConfig {

    private static final String MAPPER_PATTERN = "classpath:mapper/**/*.xml";

    @Resource(name = "routingDataSource")
    private DataSource routingDataSource;


    /**
     * MyBatisPlus 配置分页
     * @author Jiangxincan
     * @date 2020/1/7 10:22
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
     *  SQL 工厂配置
     * @param mybatisConfiguration  mybatis 配置类
     * @param globalConfig 全局配置
     * @param paginationInterceptor mybatis-plus分页插件
     * @author Jiangxincan
     * @date 2020/8/12 16:02
     * @return org.apache.ibatis.session.SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("mybatisConfiguration") MybatisConfiguration mybatisConfiguration,
            @Qualifier("globalConfig") GlobalConfig globalConfig,
            @Qualifier("paginationInterceptor") PaginationInterceptor paginationInterceptor
    ) throws Exception {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        // 设置MyBatis-Plus 分页插件
        Interceptor[] plugins = {paginationInterceptor};
        mybatisSqlSessionFactoryBean.setPlugins(plugins);
        mybatisSqlSessionFactoryBean.setDataSource(routingDataSource);
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
        mybatisSqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(MAPPER_PATTERN));
        return mybatisSqlSessionFactoryBean.getObject();
    }

    /**
     *  MyBatisPlus 配置
     * @author Jiangxincan
     * @date 2020/8/12 16:01
     * @return com.baomidou.mybatisplus.core.MybatisConfiguration
     */
    @Bean
    public MybatisConfiguration mybatisConfiguration(){
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        mybatisConfiguration.setCallSettersOnNulls(false);
        mybatisConfiguration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        return mybatisConfiguration;
    }

    /**
     *  MyBatisPlus GlobalConfig 全局配置
     * @param dbConfig 数据库配置类
     * @author Jiangxincan
     * @date 2020/8/12 15:58
     * @return com.baomidou.mybatisplus.core.config.GlobalConfig
     */
    @Bean
    public GlobalConfig globalConfig(@Qualifier("dbConfig") GlobalConfig.DbConfig dbConfig){
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setMetaObjectHandler(new MyBatisMetaObjectHandler());
        return globalConfig;
    }

    /**
     * MyBatisPlus DbConfig 数据库配置
     * @author Jiangxincan
     * @date 2020/8/12 16:00
     * @return com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig
     */
    @Bean
    public GlobalConfig.DbConfig dbConfig(){
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.ASSIGN_ID);
        return dbConfig;
    }

    /**
     *  配置事务管理器
     * @author Jiangxincan
     * @date 2020/8/12 15:59
     * @return org.springframework.transaction.PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(routingDataSource);
    }
}
