package com.dimples.auth.config;

import com.dimples.auth.handler.AuthAccessDeniedHandler;
import com.dimples.auth.handler.AuthExceptionEntryPoint;

import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.IOException;

import javax.annotation.Resource;

/**
 * 资源服务器
 * 认证中心会提供User信息，所以也是资源服务器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
//@Configuration
//@EnableResourceServer
public class Auth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private AuthExceptionEntryPoint exceptionEntryPoint;
    @Resource
    private AuthAccessDeniedHandler accessDeniedHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 防csrf攻击
        http.csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

    /**
     * 配置jwt生成token的转换
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        ClassPathResource classPathResource = new ClassPathResource("public.txt");
        String publicKey;
        try {
            publicKey = IOUtils.toString(classPathResource.getInputStream());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);
        return converter;
    }

}



















