package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2019, 心灿基础架构
 *
 * @program xincan-framework
 * MyBatisPlus 配置
 * @author Jiangxincan
 * @create 2019/12/20 15:27
 * @version 0.0.1
 * <author>                <time>                  <version>                   <description>
 * Jiangxincan         2019/12/20 15:27           0.0.1                         MyBatisPlus 配置
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * MyBatisPlus配置分页
     * @author Jiangxincan
     * @date 2020/1/7 10:22
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return  new PaginationInterceptor();
    }

}
