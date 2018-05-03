package com.rias.sharing.life.user.controller;

import com.rias.sharing.life.user.entity.User;
import com.rias.sharing.life.user.result.Result;
import com.rias.sharing.life.user.service.TokenService;
import com.rias.sharing.life.user.vo.PhoneCodeVo;
import com.rias.sharing.life.user.vo.TokenVo;
import com.rias.sharing.life.user.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @name: TokenControl
 * @author: lucifinier
 * @date: 2018/4/24 16:59
 * @description: 用户登陆注册类
 */
@Api(tags="用户登陆注册的controller")
@RestController
@RequestMapping("/token")
@Slf4j
public class TokenController {
    @Autowired
    TokenService tokenService;

    @ApiOperation(value = "手机号登陆校验", notes = "通过手机号登陆注册，校验是否存在。不存在则生成新到用户数据")
    @PostMapping("/phone")
    public Result<UserVo> checkPhoneStatus(
            @ApiParam(name = "PhoneCodeVo", value = "手机登陆模型") @Valid @RequestBody PhoneCodeVo phoneCodeVo
    ) {
        User user = tokenService.checkPhoneStatus(phoneCodeVo);
        log.debug(user.toString());

        UserVo vo = UserVo.make(user);
        log.debug(vo.toString());

        return Result.success(vo);
    }

    @ApiOperation(value = "生成token", notes = "通知后台生成token")
    @PostMapping
    public Result<TokenVo> createToken(
            @ApiParam(name = "id", value = "用户id") @Valid @RequestParam(name = "id") Integer userId
    ) {
        String token = tokenService.createTokenByUserId(userId);

        TokenVo vo = new TokenVo(userId, token);
        log.debug(vo.toString());

        return Result.success(vo);
    }

    @ApiOperation(value = "刷新token", notes = "通知后台刷新token")
    @PutMapping
    public Result<TokenVo> refreshToken(
            @ApiParam(name = "id", value = "用户id") @Valid @RequestParam(name = "id") Integer userId
    ) {
        String token = tokenService.refreshTokenByUserId(userId);

        TokenVo vo = new TokenVo(userId, token);
        log.debug(vo.toString());

        return Result.success(vo);
    }

}
