package com.dimples.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器
 * 认证中心会提供User信息，所以也是资源服务器
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Configuration
@EnableResourceServer
public class Auth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 防csrf攻击
        http.csrf().disable().requestMatchers().antMatchers("/**")
        .and()
         //添加资源控制
        .authorizeRequests().antMatchers("/actuator/**").permitAll().antMatchers("/**").authenticated()
        .and()
        .httpBasic()
        .and()
        .formLogin();
    }
}



















