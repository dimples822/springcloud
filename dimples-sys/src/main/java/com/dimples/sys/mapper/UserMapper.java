package com.dimples.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dimples.common.dto.UserDTO;
import com.dimples.sys.po.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/12/6
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查找用户详细信息
     *
     * @param page page
     * @param user 用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<User> findUserDetailPage(@Param("page") Page<User> page, @Param("user") UserDTO user);
}











