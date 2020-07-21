package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * copyright (C), 2019, 心灿基础架构
 *
 * @program hatech-framework
 * MyBatisPlus 配置
 * @author JiangXincan
 * @create 2019/12/20 15:27
 * @version 2.0.0
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2019/12/20 15:27           2.0.0                         MyBatisPlus 配置
 */
@Configuration
public class MyBatisPlusConfig {

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

}
