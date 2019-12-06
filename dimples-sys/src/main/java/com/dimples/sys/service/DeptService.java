package com.dimples.sys.service;

import com.dimples.sys.po.Dept;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
public interface DeptService {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

}

