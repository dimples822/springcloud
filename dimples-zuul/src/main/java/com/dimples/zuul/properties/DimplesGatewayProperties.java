package com.dimples.zuul.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/13
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dimples-gateway.properties"})
@ConfigurationProperties(prefix = "dimples.gateway")
public class DimplesGatewayProperties {
    /**
     * 禁止外部访问的 URI，多个值的话以逗号分隔
     */
    private String forbidRequestUri;
}