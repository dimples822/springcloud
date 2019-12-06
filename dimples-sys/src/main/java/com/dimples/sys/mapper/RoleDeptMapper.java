package com.dimples.sys.mapper;

import com.dimples.sys.po.RoleDept;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface RoleDeptMapper {
    int deleteByPrimaryKey(Long roleDeptId);

    int insertSelective(RoleDept record);

    RoleDept selectByPrimaryKey(Long roleDeptId);

    int updateByPrimaryKeySelective(RoleDept record);

    int updateByPrimaryKey(RoleDept record);
}