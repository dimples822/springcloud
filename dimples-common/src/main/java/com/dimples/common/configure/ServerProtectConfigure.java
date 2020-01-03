package com.dimples.common.configure;

import com.dimples.common.interceptor.ServerProtectInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/3
 */
public class ServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor serverProtectInterceptor() {
        return new ServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(serverProtectInterceptor());
    }

}
