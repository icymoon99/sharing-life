package com.rias.sharing.life.user.service;

import com.rias.sharing.life.user.entity.User;

/**
 * @name: UserService
 * @author: lucifinier
 * @date: 2018/4/25 15:04
 * @description: 用户服务接口
 */
public interface UserService {
    User getUserById(Long id);
}
