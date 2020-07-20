package cn.com.xincan.xincanframework.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * copyright (C), 2020, 北京同创永益科技发展有限公司
 *
 * @author JiangXincan
 * @version 1.0
 * <author>                <time>                  <version>                   <description>
 * JiangXincan         2020/5/25 21:39             1.0                         自定义配置类
 * @program xincan-nacos
 * @description 自定义配置类
 * @create 2020/5/25 21:39
 */
@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "xincan")
public class XincanNacosProperties {

    private String id;

    private String name;

}
