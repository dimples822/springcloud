package com.dimples.auth.fallback;

import com.dimples.auth.feign.SysFeignService;
import com.dimples.common.exception.BizException;
import com.dimples.common.result.ResultCommon;
import com.dimples.common.vo.PermissionVo;
import com.dimples.common.vo.RoleVo;
import com.dimples.common.vo.UserVo;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/8
 */
@Slf4j
@Service
public class SysFeignServiceFallBackImpl implements SysFeignService {

    @Override
    public ResultCommon<UserVo> findByUsername(String username) {
        log.info("调用{}失败", "findByUsername");
        throw new BizException("调用findByUsername接口失败");
    }

    @Override
    public ResultCommon<List<RoleVo>> getRoleByUserId(Long userId) {
        log.info("调用{}失败", "getRoleByUserId");
        throw new BizException("调用getRoleByUserId失败");
    }

    @Override
    public ResultCommon<List<PermissionVo>> getRolePermission(Long roleId) {
        log.info("调用{}失败", "getRolePermission");
        throw new BizException("调用getRolePermission失败");
    }

}
