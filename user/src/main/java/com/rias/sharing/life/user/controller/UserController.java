package com.rias.sharing.life.user.controller;

import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.user.entity.User;
import com.rias.sharing.life.user.service.UserService;
import com.rias.sharing.life.user.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @name: UserControl
 * @author: lucifinier
 * @date: 2018/4/25 15:02
 * @description: 用户管理的controller
 */
@Api(tags="用户User的controller")
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value="根据id获取用户信息", notes="根据id获取用户信息")
    @GetMapping("/{id}")
    public Result<UserVo> getUserById(
            @ApiParam(name="id",value="用户ID")@PathVariable("id") @NotNull  Long id) {
        User user = userService.getUserById(id);

        return Result.success(UserVo.make(user));
    }
}
