package com.rias.sharing.life.user.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @name: User
 * @author: lucifinier
 * @date: 2018/4/24 17:57
 * @description: 用户类
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户头像
     */
    private String imgUrl;
    /**
     * 用户性别
     */
    private Integer sex;
    /**
     * 用户生日
     */
    private LocalDate birthday;
}
