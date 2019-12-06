package com.dimples.auth.config;

import com.dimples.auth.handler.AuthAccessDeniedHandler;
import com.dimples.auth.handler.AuthExceptionEntryPoint;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

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

}



















