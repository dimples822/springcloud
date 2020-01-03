package com.dimples.server.test.configure;

import com.dimples.common.handler.AuthAccessDeniedHandler;
import com.dimples.common.handler.AuthExceptionEntryPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器配置
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
@Configuration
@EnableResourceServer
public class TestResourceServerConfigure extends ResourceServerConfigurerAdapter {

    private AuthAccessDeniedHandler accessDeniedHandler;
    private AuthExceptionEntryPoint exceptionEntryPoint;

    @Autowired
    public TestResourceServerConfigure(AuthAccessDeniedHandler accessDeniedHandler, AuthExceptionEntryPoint exceptionEntryPoint) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.exceptionEntryPoint = exceptionEntryPoint;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

}














