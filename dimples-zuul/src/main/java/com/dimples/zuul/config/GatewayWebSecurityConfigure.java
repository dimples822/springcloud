package com.dimples.zuul.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 关闭csrf功能，否则会报csrf相关异常
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/24
 */
@EnableWebSecurity
public class GatewayWebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

}











