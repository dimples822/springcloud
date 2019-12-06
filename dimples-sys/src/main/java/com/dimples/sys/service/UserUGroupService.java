package com.dimples.sys.service;

import com.dimples.sys.po.UserUGroup;

public interface UserUGroupService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(UserUGroup record);

    UserUGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserUGroup record);

    int updateByPrimaryKey(UserUGroup record);

}

