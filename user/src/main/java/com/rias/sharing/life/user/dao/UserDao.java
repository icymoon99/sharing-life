package com.rias.sharing.life.user.dao;

import com.rias.sharing.life.user.dao.mapper.UserMapper;
import com.rias.sharing.life.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: UserDao
 * @author: lucifinier
 * @date: 2018/4/24 18:00
 * @description: 用户表操作类
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper mapper;

    public User getUserByPhone (String phone) {
        return mapper.getUserByPhone(phone);
    }

    public User UsergetUserById (int id) {
        return mapper.getUserById(id);
    }

    public void saveDefaultUser (User user) {
        mapper.saveUser(user);
    }
}
