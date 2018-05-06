package com.rias.sharing.life.user.dao.mapper;

import com.rias.sharing.life.user.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * @name: UserProvider
 * @author: lucifinier
 * @date: 2018/4/28 10:30
 * @description: TODO
 */
public class UserProvider {
    final static String COL_ID = "id";
    final static String COL_NICK_NAME = "nick_name";
    final static String COL_PHONE = "phone";
    final static String COL_IMG_URL = "img_url";
    final static String COL_SEX = "sex";
    final static String COL_BIRTHDAY = "birthday";

    final static String VAL_ID = "#{id}";
    final static String VAL_NICK_NAME = "#{nickName}";
    final static String VAL_PHONE = "#{phone}";
    final static String VAL_IMG_URL = "#{imgUrl}";
    final static String VAL_SEX = "#{sex}";
    final static String VAL_BIRTHDAY = "#{birthday}";

    public String saveUser(User user) {
        return new SQL() {{
            INSERT_INTO("user");
            if (user.getId() != null) {
                VALUES(COL_ID, VAL_ID);
            }
            if (user.getNickName() != null) {
                VALUES(COL_NICK_NAME, VAL_NICK_NAME);
            }
            if (user.getPhone() != null) {
                VALUES(COL_PHONE, VAL_PHONE);
            }
            if (user.getImgUrl() != null) {
                VALUES(COL_IMG_URL, VAL_IMG_URL);
            }
            if (user.getSex() != null) {
                VALUES(COL_SEX, VAL_SEX);
            }
            if (user.getBirthday() != null) {
                VALUES(COL_BIRTHDAY, VAL_BIRTHDAY);
            }
        }}.toString();
    }
}
