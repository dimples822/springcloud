package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

/**
 * SpringCloud注册中心
 *
 * @author zhongyj
 * @date 2019/8/12
 */
@Slf4j
@SpringBootApplication
@EnableEurekaServer

public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
        log.info("*****************Eureka Server 程序已启动******************");
    }

}

































