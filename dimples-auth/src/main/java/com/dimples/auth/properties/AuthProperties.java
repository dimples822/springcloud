package com.dimples.auth.properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2020/1/8
  */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:dimples-auth.properties"})
@ConfigurationProperties(prefix = "dimples.auth")
public class AuthProperties {

    /**
     * 免认证访问路径
     */
    private String anonUrl;

    /**
     * 支持的认证方式
     */
    private String grantType;
    /**
     * JWT加签密钥
     */
    private String jwtAccessKey;
    /**
     * 是否使用 JWT令牌
     */
    private Boolean enableJwt;

    /**
     * 社交登录所使用的 Client
     */
    private String socialLoginClientId;
}
