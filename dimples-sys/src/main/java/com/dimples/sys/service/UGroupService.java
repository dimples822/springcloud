package com.dimples.sys.service;

import com.dimples.sys.po.UGroup;

public interface UGroupService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(UGroup record);

    UGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UGroup record);

    int updateByPrimaryKey(UGroup record);

}

