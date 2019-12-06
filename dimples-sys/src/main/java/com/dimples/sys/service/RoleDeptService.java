package com.dimples.sys.service;

import com.dimples.sys.po.RoleDept;

public interface RoleDeptService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(RoleDept record);

    RoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDept record);

    int updateByPrimaryKey(RoleDept record);

}

