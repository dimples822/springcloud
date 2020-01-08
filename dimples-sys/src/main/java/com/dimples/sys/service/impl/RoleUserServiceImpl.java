package com.dimples.sys.service.impl;

import com.dimples.common.eunm.CodeAndMessageEnum;
import com.dimples.common.exception.BizException;
import com.dimples.common.utils.SysConstant;
import com.dimples.sys.mapper.RoleUserMapper;
import com.dimples.sys.service.RoleUserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Resource
    private RoleUserMapper roleUserMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int bingUserAndRole(Long userId, String roleIds) {
        String[] params = roleIds.split(SysConstant.PRAMS_SEPARATOR);
        if (params.length == 0 || userId == null) {
            throw new BizException(CodeAndMessageEnum.REQUEST_INVALIDATE);
        }
        List<String> roles = Arrays.asList(params);
        return roleUserMapper.bindUserAndRoles(userId, roles);
    }
}
















