package com.dimples.sys.mapper;

import com.dimples.sys.po.UGroup;

import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UGroupMapper {
    int deleteByPrimaryKey(Long uGroupId);

    int insertSelective(UGroup record);

    UGroup selectByPrimaryKey(Long uGroupId);

    int updateByPrimaryKeySelective(UGroup record);

    int updateByPrimaryKey(UGroup record);
}