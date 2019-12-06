package com.dimples.sys.mapper;

import com.dimples.sys.po.Position;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface PositionMapper {
    int deleteByPrimaryKey(Long positionId);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long positionId);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}