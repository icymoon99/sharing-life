package com.rias.sharing.life.user.service.impl;

import com.rias.sharing.life.user.dao.UserDao;
import com.rias.sharing.life.user.entity.User;
import com.rias.sharing.life.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @name: UserServiceImpl
 * @author: lucifinier
 * @date: 2018/4/25 15:05
 * @description: 用户服务
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(int id) {
        User user = userDao.UsergetUserById(id);
        log.debug(user.toString());

        return user;
    }
}
