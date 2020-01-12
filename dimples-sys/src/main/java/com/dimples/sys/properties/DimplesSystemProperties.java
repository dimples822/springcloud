package com.dimples.sys.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/9
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dimples-server-system.properties"})
@ConfigurationProperties(prefix = "dimples.system")
public class DimplesSystemProperties {

    /**
     * 免认证 URI，多个值的话以逗号分隔
     */
    private String anonUrl;

    private DimplesSwaggerProperties swagger = new DimplesSwaggerProperties();

}

















