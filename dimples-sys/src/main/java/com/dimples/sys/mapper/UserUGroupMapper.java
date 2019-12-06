package com.dimples.sys.mapper;

import com.dimples.sys.po.UserUGroup;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UserUGroupMapper {
    int deleteByPrimaryKey(Long userUGroupId);

    int insertSelective(UserUGroup record);

    UserUGroup selectByPrimaryKey(Long userUGroupId);

    int updateByPrimaryKeySelective(UserUGroup record);

    int updateByPrimaryKey(UserUGroup record);
}