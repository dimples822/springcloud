package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RoleUGroupMapper;
import com.dimples.sys.service.RoleUGroupService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class RoleUGroupServiceImpl implements RoleUGroupService {

    @Resource
    private RoleUGroupMapper roleUGroupMapper;

}

