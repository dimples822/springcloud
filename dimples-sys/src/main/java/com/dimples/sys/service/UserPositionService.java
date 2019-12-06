package com.dimples.sys.service;

import com.dimples.sys.po.UserPosition;

public interface UserPositionService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);

}

