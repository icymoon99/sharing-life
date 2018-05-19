package com.rias.sharing.life.merchant.control;

import com.rias.sharing.life.common.result.Result;
import com.rias.sharing.life.common.validator.IsMobile;
import com.rias.sharing.life.merchant.entity.AuditInfo;
import com.rias.sharing.life.merchant.service.MerchantService;
import com.rias.sharing.life.merchant.vo.AuditInfoVo;
import com.rias.sharing.life.merchant.vo.MerchantVo;
import com.rias.sharing.life.merchant.vo.PhoneCodeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:商户端登陆注册控制层
 * @author:yangyu
 * @date: 2018/4/25
 */
@Api(tags = "商户端注册")
@RestController
@RequestMapping("/merchant")
public class MerChantController {
    private static final Logger logger = LoggerFactory.getLogger(MerChantController.class);

    @Autowired
    MerchantService merchantService;

    /**
     * @Description:商户注册接口
     * @author:yangyu
     * @date:2018/4/24
     */
    @ApiOperation(value = "通过电话号码获取商户", notes = "商户详细信息注册")
    @GetMapping
    public Result<MerchantVo> getMerchantByPhone(
            @ApiParam(name = "phone", value = "商户电话")
            @IsMobile @RequestParam() String phone) {

        MerchantVo vo = merchantService.getMerchantByPhone(phone);
        return Result.success(vo);
    }

    /**
     * @Description:商户注册接口
     * @author:yangyu
     * @date:2018/4/24
     */
    @ApiOperation(value = "商户注册", notes = "商户详细信息注册")
    @PostMapping
    public Result<String> registerMerchant(
            @ApiParam(name = "merchantDto", value = "注册模型")
            @Validated @RequestBody() MerchantVo merchantVo) {

        merchantService.saveJztMerchant(merchantVo);
        return Result.success();

    }

    /**
     * @Description:商户注册接口
     * @author:yangyu
     * @date:2018/4/24
     */
    @ApiOperation(value = "商户信息修改", notes = "商户信息修改")
    @PutMapping
    public Result<String> updateMerchant(
            @ApiParam(name = "merchantDto", value = "注册模型")
            @Validated @RequestBody() MerchantVo merchantVo) {

        merchantService.updateMerchant(merchantVo);
        return Result.success();

    }

    /**
     * @Description:商户发送手机验证码
     * @author:yangyu
     * @date:2018/4/27
     */
    @ApiOperation(value = "手机验证", notes = "商户获取手机验证码")
    @PostMapping("/phone/code")
    public Result<String> sendCodeByPhone(
            @ApiParam(name = "phoneLoginQuery", value = "发送手机验证")
            @Validated @RequestBody() PhoneCodeVo phoneCodeVo) {

        merchantService.sendCodeByPhone(phoneCodeVo);
        return Result.success();

    }

    @ApiOperation(value = "审核不通过信息", notes = "审核不通过信息")
    @GetMapping("/audit/info")
    public Result<List<AuditInfoVo>> checkMerchantMsg(
            @ApiParam(name = "id", value = "商户id")
            @NotNull @RequestParam() Long id) {

            List<AuditInfo> infos = merchantService.getBymerchantId(id);

            List<AuditInfoVo> vos = infos.stream()
                    .map(info -> AuditInfoVo.make(info))
                    .collect(Collectors.toList());

            return Result.success(vos);
    }
}
