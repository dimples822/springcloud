package com.dimples.auth.config;

import com.dimples.auth.handler.AuthAccessDeniedHandler;
import com.dimples.auth.handler.AuthExceptionEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * 资源服务器
 * 认证中心会提供User信息，注销当前Token等，所以也是资源服务器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Configuration
@EnableResourceServer
public class Auth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String SECURITY_ALL_UTL = "/**";
    private AuthAccessDeniedHandler accessDeniedHandler;
    private AuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    public Auth2ResourceServerConfig(AuthAccessDeniedHandler accessDeniedHandler, AuthExceptionEntryPoint exceptionEntryPoint) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.exceptionEntryPoint = exceptionEntryPoint;
    }

    /**
     * requestMatchers().antMatchers("/**")的配置表明该安全配置对所有请求都生效
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers(SECURITY_ALL_UTL)
                .and()
                .authorizeRequests().antMatchers(SECURITY_ALL_UTL).authenticated()
                .and().httpBasic();
    }

    /**
     * 配置jwt生成token的转换
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.txt");
        String publicKey;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            publicKey = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        converter.setSigningKey(publicKey);
        return converter;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

}



















