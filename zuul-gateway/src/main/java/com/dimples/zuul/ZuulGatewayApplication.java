package com.dimples.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Zuul网关示例
 *
 * @author zhongyj
 * @date 2019/8/13
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@Slf4j
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
        log.info("*****************Zuul 程序已启动******************");
    }

}
