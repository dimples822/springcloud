package com.dimples.sys.service;

import com.dimples.sys.po.Position;

public interface PositionService {


    int deleteByPrimaryKey(Long id);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

}

