package com.rias.sharing.life.user.vo;

import com.rias.sharing.life.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.format.DateTimeFormatter;

/**
 * @name: UserVo
 * @author: lucifinier
 * @date: 2018/4/24 17:57
 * @description: 用户类
 */
@ApiModel(value="获取User前台模型",description="获取User前台模型")
@Data
public class UserVo {
    @ApiModelProperty(value="用户ID",example="420")
    private Integer id;

    @ApiModelProperty(value="昵称",example="张三")
    private String nickName;

    @ApiModelProperty(value="昵称",example="13712345678")
    private String phone;

    @ApiModelProperty(value="头像地址",example="http://baidu.com/123.jpg")
    private String imgUrl;

    @ApiModelProperty(value="用户性别",example="420")
    private Integer sex;

    @ApiModelProperty(value="用户生日",example="2008-05-01")
    private String birthday;

    public static UserVo make(User user) {
        UserVo vo = new UserVo();

        vo.setId(user.getId());
        vo.setNickName(user.getNickName());
        vo.setPhone(user.getPhone());
        vo.setImgUrl(user.getImgUrl());
        vo.setSex(user.getSex());
        vo.setBirthday(user.getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE));

        return vo;
    }
}
