package com.dimples.server.test.service;

import com.dimples.common.constant.ApplicationNameConstant;
import com.dimples.server.test.service.feign.SysInfoServiceFallback;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/30
 */
@FeignClient(value = ApplicationNameConstant.SYS, contextId = "sysInfoServiceClient", fallbackFactory = SysInfoServiceFallback.class)
public interface SysInfoService {

    /**
     * 获取dimples-sys的info
     *
     * @return String
     */
    @GetMapping("info")
    String info();

}
