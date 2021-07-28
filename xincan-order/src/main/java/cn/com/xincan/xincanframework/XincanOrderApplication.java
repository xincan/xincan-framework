package cn.com.xincan.xincanframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * copyright (C), 2020, 心灿基础架构
 *
 * @author Jiangxincan
 * @version 0.0.1
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class XincanOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XincanOrderApplication.class, args);
    }

}
