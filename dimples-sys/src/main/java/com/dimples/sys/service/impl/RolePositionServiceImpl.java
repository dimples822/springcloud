package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RolePositionMapper;
import com.dimples.sys.service.RolePositionService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Service
public class RolePositionServiceImpl implements RolePositionService {

    @Resource
    private RolePositionMapper rolePositionMapper;

}


