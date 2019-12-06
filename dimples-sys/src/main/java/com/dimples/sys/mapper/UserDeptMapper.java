package com.dimples.sys.mapper;

import com.dimples.sys.po.UserDept;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UserDeptMapper {
    int deleteByPrimaryKey(Long userDeptId);

    int insertSelective(UserDept record);

    UserDept selectByPrimaryKey(Long userDeptId);

    int updateByPrimaryKeySelective(UserDept record);

    int updateByPrimaryKey(UserDept record);
}