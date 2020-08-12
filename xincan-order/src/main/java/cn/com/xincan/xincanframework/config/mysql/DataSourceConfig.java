package cn.com.xincan.xincanframework.config.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-framework
 * @description 数据库配置
 * @create 2020/7/31 13:43
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2020/7/31 13:43             1.0                         数据库配置
 */
@Configuration
public class DataSourceConfig {

//    @Bean("master")
//    @ConfigurationProperties("spring.datasource.master")
//    public DataSource master(){
//        DataSource dataSource = DataSourceBuilder.create().build();
//        return dataSource;
//    }
//
//    @Bean("hikariMaster")
//    @ConfigurationProperties("spring.datasource.master.hikari")
//    public HikariConfig hikariMaster(){
//        return new HikariConfig();
//    }




}
