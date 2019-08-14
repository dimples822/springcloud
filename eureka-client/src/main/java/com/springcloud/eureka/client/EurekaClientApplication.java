package com.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

/**
 * eureka客户端测试
 *
 * @author zhongyj
 * @date 2019/8/13
 */
@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
        log.info("*****************Eureka Client 程序已启动 ******************");
    }

}
