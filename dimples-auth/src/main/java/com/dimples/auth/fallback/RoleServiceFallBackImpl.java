package com.dimples.auth.fallback;

import com.dimples.auth.service.RoleService;
import com.dimples.common.result.ResultCommon;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/5
 */
@Slf4j
@Service
public class RoleServiceFallBackImpl implements RoleService {
    @Override
    public ResultCommon getRoleByUserId(Integer userId) {
        log.info("调用{}失败", "getRoleByUserId");
        return ResultCommon.failed("调用getRoleByUserId失败");
    }
}














