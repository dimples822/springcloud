package com.dimples.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj
 * @date 2019/8/13
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("***************** 程序已启动 ******************");
    }

}
