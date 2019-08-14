package com.springcloud.eureka.client.controller;

import com.sprig.cloud.common.vo.ResultVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试类
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/14
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/zuul/{name}")
    public Map<String, Object> testZuul(@PathVariable String name) {
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", name);
        return ResultVO.success(map);
    }
}
