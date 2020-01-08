package com.dimples.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dimples.common.dto.UserDTO;
import com.dimples.common.transport.RequestWithPageDTO;
import com.dimples.sys.po.User;

/**
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2020/1/6
 */
public interface UserService extends IService<User> {

    /**
     * 查找用户详细信息
     *
     * @param request request
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<UserDTO> findUserDetail(UserDTO user, RequestWithPageDTO request);

    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(User user);

    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUsers(String[] userIds);

}

