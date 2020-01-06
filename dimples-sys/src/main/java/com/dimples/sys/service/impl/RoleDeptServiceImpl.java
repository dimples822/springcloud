package com.dimples.sys.service.impl;

import com.dimples.sys.mapper.RoleDeptMapper;
import com.dimples.sys.service.RoleDeptService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
  *
  * @author zhongyj <1126834403@qq.com><br/>
  * @date 2019/12/6
  */
@Service
public class RoleDeptServiceImpl implements RoleDeptService {

    @Resource
    private RoleDeptMapper roleDeptMapper;

}

