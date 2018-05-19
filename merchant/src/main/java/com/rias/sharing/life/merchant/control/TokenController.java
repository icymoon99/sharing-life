package com.rias.sharing.life.merchant.control;

import com.rias.sharing.life.common.result.CodeMsg;
import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.merchant.service.TokenService;
import com.rias.sharing.life.merchant.vo.HrVo;
import com.rias.sharing.life.merchant.vo.TakenVo;
import com.rias.sharing.life.merchant.vo.PhoneCodeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Description:商户端登陆注册控制层
 * @author:yangyu
 * @date: 2018/4/25
 */
@Api(tags = "hr登陆")
@Slf4j
@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    TokenService tokenService;

    /**
     * @Description:hr发送手机验证码
     * @author:yangyu
     * @date:2018/5/03
     */
    @ApiOperation(value = "手机验证", notes = "通过手机号登陆")
    @PostMapping("/phone")
    public Result<HrVo> checkPhoneStatus(
            @ApiParam(name = "phoneLoginQuery", value = "发送手机验证")
            @Validated @RequestBody() PhoneCodeVo phoneCodeVo) {

            HrVo vo = tokenService.checkPhoneStatus(phoneCodeVo);

            return Result.success(vo);
    }

    /**
     * @Description:短信校验（takening）
     * @author:郑鹏宇
     * @date:2018/4/11
     */
    @ApiOperation(value = "生成taken", notes = "通知后台生成token")
    @PostMapping
    public Result<TakenVo> createToken(
            @ApiParam(name = "id", value = "HR id")
            @NotNull @RequestParam(name = "id") Long hrId) {

        TakenVo vo = tokenService.createToken(hrId);

        return Result.success(vo);
    }

    @ApiOperation(value = "自动登陆", notes = "根据HR id判断是否可以自动登陆")
    @PutMapping
    public Result<TakenVo> refreshToken(
            @ApiParam(name = "id", value = "HR id")
            @NotNull @RequestParam(name = "id") Long hrId) {

        TakenVo vo = tokenService.refreshToken(hrId);

        return Result.success(vo);
    }
}
