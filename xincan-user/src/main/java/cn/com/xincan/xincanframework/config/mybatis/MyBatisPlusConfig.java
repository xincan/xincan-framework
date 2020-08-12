package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @program hatech-framework
 * MyBatisPlus 配置
 * @author JiangXincan
 * @create 2019/12/20 15:27
 * @version 0.0.1
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2019/12/20 15:27             0.0.1                         MyBatisPlus 配置
 */
@EnableTransactionManagement
@Configuration
@MapperScan("cn.com.xincan.xincanframework.server.*.mapper")
public class MyBatisPlusConfig {

    @Resource(name = "routingDataSource")
    private DataSource routingDataSource;


    /**
     * MyBatisPlus配置分页
     * @author JiangXincan
     * @date 2020/1/7 10:22
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(routingDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(routingDataSource);
    }

}
