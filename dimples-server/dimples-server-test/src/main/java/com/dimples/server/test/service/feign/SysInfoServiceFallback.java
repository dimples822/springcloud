package com.dimples.server.test.service.feign;

import com.dimples.server.test.service.SysInfoService;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/30
 */
@Slf4j
@Component
public class SysInfoServiceFallback implements FallbackFactory<SysInfoService> {

    @Override
    public SysInfoService create(Throwable throwable) {
        return () -> {
            log.error("调用 dimples-sys 服务出错", throwable);
            return "调用出错";
        };
    }

}

















