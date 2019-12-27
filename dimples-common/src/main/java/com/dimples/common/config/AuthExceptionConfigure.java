package com.dimples.common.config;

import com.dimples.common.handler.AuthAccessDeniedHandler;
import com.dimples.common.handler.AuthExceptionEntryPoint;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/27
 */
public class AuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public AuthAccessDeniedHandler accessDeniedHandler() {
        return new AuthAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public AuthExceptionEntryPoint authenticationEntryPoint() {
        return new AuthExceptionEntryPoint();
    }

}
