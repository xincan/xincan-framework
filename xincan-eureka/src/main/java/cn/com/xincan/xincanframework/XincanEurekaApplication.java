package cn.com.xincan.xincanframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author JiangXincan
 * @version 0.0.1
 * @program xincan-eureka
 * 服务注册与发现中心
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             0.0.1                         服务注册与发现中心
 */
@EnableEurekaServer
@SpringBootApplication
public class XincanEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XincanEurekaApplication.class, args);
    }

}
