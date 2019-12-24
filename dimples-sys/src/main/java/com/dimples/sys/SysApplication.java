package com.dimples.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

/**
 * EnableGlobalMethodSecurity(prePostEnabled = true):表示开启security注解权限
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Slf4j
@SpringBootApplication
public class SysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }
}
