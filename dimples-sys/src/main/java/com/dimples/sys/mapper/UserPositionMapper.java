package com.dimples.sys.mapper;

import com.dimples.sys.po.UserPosition;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UserPositionMapper {
    int deleteByPrimaryKey(Long userPositionId);

    int insertSelective(UserPosition record);

    UserPosition selectByPrimaryKey(Long userPositionId);

    int updateByPrimaryKeySelective(UserPosition record);

    int updateByPrimaryKey(UserPosition record);
}