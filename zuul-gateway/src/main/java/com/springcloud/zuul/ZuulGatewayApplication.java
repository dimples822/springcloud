package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

import lombok.extern.slf4j.Slf4j;

/**
 * Zuul网关示例
 *
 * @author zhongyj
 * @date 2019/8/13
 */
@SpringBootApplication
@EnableZuulServer
@EnableEurekaClient
@Slf4j
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
        log.info("*****************Zuul 程序已启动******************");
    }

}
