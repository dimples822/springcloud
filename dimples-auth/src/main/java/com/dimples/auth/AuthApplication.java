package com.dimples.auth;

import com.dimples.common.annotation.EnableAuthExceptionHandler;
import com.dimples.common.annotation.EnableServerProtect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj
 * @date 2019/8/13
 */
@EnableAuthExceptionHandler
@EnableServerProtect
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
        log.info("***************** 程序已启动 ******************");
    }

}
