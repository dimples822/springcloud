package com.dimples.sys;

import com.dimples.common.annotation.EnableAuthExceptionHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import lombok.extern.slf4j.Slf4j;

/**
 * EnableGlobalMethodSecurity(prePostEnabled = true):表示开启security注解权限
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@EnableAuthExceptionHandler
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}
