package com.dimples.sys.mapper;

import com.dimples.sys.po.RolePosition;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RolePositionMapper {
    int deleteByPrimaryKey(Long rolePositionId);

    int insertSelective(RolePosition record);

    RolePosition selectByPrimaryKey(Long rolePositionId);

    int updateByPrimaryKeySelective(RolePosition record);

    int updateByPrimaryKey(RolePosition record);
}