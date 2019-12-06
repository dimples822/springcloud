package com.dimples.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity安全认证配置类
 * 配置security的授权信息
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置基本权限
     * 拦截所有请求路径都被权限进行拦截
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
    }

    /**
     * 认证管理配置
     * 未加密的密码为：123456
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("$2a$10$TBrSoIWEiAQaEEPswpl1guJ7vqt6Z/lMLWD3lhDy0UAVxMHpSBvie").roles("USER")
                .and()
                .withUser("admin").password("$2a$10$TBrSoIWEiAQaEEPswpl1guJ7vqt6Z/lMLWD3lhDy0UAVxMHpSBvie").roles("ADMIN");
    }

    /**
     * 授权认证管理者实例化
     *
     * @return AuthenticationManager
     * @throws Exception Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 密码加密方式
     * 采用BCryptPasswordEncoder加密方式
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
















