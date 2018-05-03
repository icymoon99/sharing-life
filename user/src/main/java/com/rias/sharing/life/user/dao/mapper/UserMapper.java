package com.rias.sharing.life.user.dao.mapper;

import com.rias.sharing.life.user.entity.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @name: UserMapper
 * @author: lucifinier
 * @date: 2018/4/24 18:01
 * @description: 用户表mapper
 */
public interface UserMapper {
    @Select("SELECT * FROM user where phone = #{phone} ")
    User getUserByPhone (String phone);

    @Select("SELECT * FROM user where id = #{id} ")
    @Results({
            @Result(column = "nick_name", property = "nickName"),
            @Result(column = "img_url", property = "imgUrl")
    })
    User getUserById (int id);

    @InsertProvider(type = UserProvider.class,method = "saveUser")
    void saveUser(User user);
}
