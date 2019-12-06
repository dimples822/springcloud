package com.dimples.sys.service;

import com.dimples.sys.po.RoleUGroup;

public interface RoleUGroupService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(RoleUGroup record);

    RoleUGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleUGroup record);

    int updateByPrimaryKey(RoleUGroup record);

}

