package com.dimples.sys.service;

import com.dimples.sys.po.RolePosition;

public interface RolePositionService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(RolePosition record);

    RolePosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePosition record);

    int updateByPrimaryKey(RolePosition record);

}

