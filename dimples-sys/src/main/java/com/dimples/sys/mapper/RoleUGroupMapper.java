package com.dimples.sys.mapper;

import com.dimples.sys.po.RoleUGroup;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleUGroupMapper {
    int deleteByPrimaryKey(Long roleUGroupId);

    int insertSelective(RoleUGroup record);

    RoleUGroup selectByPrimaryKey(Long roleUGroupId);

    int updateByPrimaryKeySelective(RoleUGroup record);

    int updateByPrimaryKey(RoleUGroup record);
}