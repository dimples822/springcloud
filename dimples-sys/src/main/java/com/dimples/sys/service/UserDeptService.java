package com.dimples.sys.service;

import com.dimples.sys.po.UserDept;

public interface UserDeptService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(UserDept record);

    UserDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDept record);

    int updateByPrimaryKey(UserDept record);

}

