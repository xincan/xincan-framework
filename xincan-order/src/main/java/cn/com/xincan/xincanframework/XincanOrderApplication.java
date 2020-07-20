package cn.com.xincan.xincanframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * @program xincan-order
 * 系统更新信息试图
 * @create 2020/3/19 14:54
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/3/19 14:54             1.0                         系统更新信息试图
 */

@EnableDiscoveryClient
@SpringBootApplication
public class XincanOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XincanOrderApplication.class, args);
    }

}
