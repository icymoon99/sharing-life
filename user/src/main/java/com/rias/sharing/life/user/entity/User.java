package com.rias.sharing.life.user.entity;

import java.time.LocalDate;

/**
 * @name: User
 * @author: lucifinier
 * @date: 2018/4/24 17:57
 * @description: 用户类
 */
public class User {
    /**
     * 用户ID
     */
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
