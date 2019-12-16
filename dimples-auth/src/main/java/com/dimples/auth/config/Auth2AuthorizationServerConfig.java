package com.dimples.auth.config;

import com.dimples.auth.service.impl.RedisClientDetailsServiceImpl;
import com.dimples.auth.service.impl.UserDetailsServiceImpl;
import com.dimples.auth.translator.AuthWebResponseExceptionTranslator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.UUID;

import javax.annotation.Resource;

/**
 * 认证服务器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Configuration
@EnableAuthorizationServer
public class Auth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsServiceImpl userDetailsService;
    @Resource
    private AuthWebResponseExceptionTranslator exceptionTranslator;
    @Resource
    private RedisConnectionFactory redisConnectionFactory;
    @Resource
    private RedisClientDetailsServiceImpl redisClientDetailsService;

    /**
     * 开启授权服务器的access_token以及check_token节点
     * access_token路径开放使用
     * check_token路径需要认证后使用
     *
     * @param security AuthorizationServerSecurityConfigurer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     * 客户端相关配置
     * 配置令牌的存储位置等
     *
     * @param clients ClientDetailsServiceConfigurer
     * @throws Exception Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(redisClientDetailsService);
    }

    /**
     * 配置授权节点信息
     *
     * @param endpoints AuthorizationServerEndpointsConfigurer
     */
    @SuppressWarnings("unchecked")
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                // 配置token存储源
                .tokenStore(tokenStore())
                // 配置权限管理
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                // 配置access_token使用的转换
                .accessTokenConverter(jwtAccessTokenConverter())
                // 配置异常翻译
                .exceptionTranslator(exceptionTranslator);
    }

    /**
     * 配置token存储源
     * 采用jwt作为Token生成格式
     * 并且使用RSA非对称进行加密
     *
     * @return TokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        // 默认可配置成 return new JwtTokenStore(jwtAccessTokenConverter())
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        // 解决每次生成的 token都一样的问题
        redisTokenStore.setAuthenticationKeyGenerator(oAuth2Authentication -> UUID.randomUUID().toString());
        return redisTokenStore;
    }

    /**
     * 配置jwt生成token的转换
     * 使用RSA Sign Key 进行加密
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("dimples.jks"), "dimples".toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        DefaultAccessTokenConverter defaultAccessTokenConverter = (DefaultAccessTokenConverter) converter.getAccessTokenConverter();
        DefaultUserAuthenticationConverter defaultUserAuthenticationConverter = new DefaultUserAuthenticationConverter();
        defaultUserAuthenticationConverter.setUserDetailsService(userDetailsService);
        defaultAccessTokenConverter.setUserTokenConverter(defaultUserAuthenticationConverter);
        // 配置私钥加密
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("dimples"));
        return converter;
    }

    /**
     * 完成token生成、过期等
     *
     * @return DefaultTokenServices
     */
    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(redisClientDetailsService);
        return tokenServices;
    }

    /**
     * 根据用户密码的方式获取token
     *
     * @param authenticationManager AuthenticationManager
     * @param oAuth2RequestFactory  OAuth2RequestFactory
     * @return ResourceOwnerPasswordTokenGranter
     */
    @Bean
    public ResourceOwnerPasswordTokenGranter resourceOwnerPasswordTokenGranter(AuthenticationManager authenticationManager, OAuth2RequestFactory oAuth2RequestFactory) {
        DefaultTokenServices defaultTokenServices = defaultTokenServices();
        return new ResourceOwnerPasswordTokenGranter(authenticationManager, defaultTokenServices, redisClientDetailsService, oAuth2RequestFactory);
    }

    /**
     * @return DefaultOAuth2RequestFactory
     */
    @Bean
    public DefaultOAuth2RequestFactory oAuth2RequestFactory() {
        return new DefaultOAuth2RequestFactory(redisClientDetailsService);
    }

}

















