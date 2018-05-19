package com.rias.sharing.life.merchant.vo;

import com.rias.sharing.life.common.validator.IsMobile;
import com.rias.sharing.life.merchant.entity.Hr;
import com.rias.sharing.life.merchant.entity.Merchant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;

/**
 * @Description:商户模型
 * @author:yangyu
 * @date: 2018/4/25
 */
@ApiModel(value="merchnatQuery",description="商户模型")
@Data
public class MerchantVo {
    @ApiModelProperty(value="用户Id",example = "1")
    @NotNull
    private Long hrId;

    @ApiModelProperty(value="商户id",example = "11")
    @NotNull
    private Long merchantId;

    @ApiModelProperty(value="真实姓名",example = "张三")
    @NotNull
    private String realName;

    @ApiModelProperty(value="省份证号",example = "420111111111111111")
    @NotNull
    @Length(min = 18, max = 18)
    private String idCard;

    @ApiModelProperty(value="商户名称",example = "美岱房源")
    @NotNull
    private String companyName;

    @ApiModelProperty(value="登陆电话",example = "15172298516")
    @IsMobile
    private String phone;

    @ApiModelProperty(value="商户电话",example = "027-88888888")
    @NotNull
    private String telephone;

    @ApiModelProperty(value="证件照片地址",example = "http://")
    @NotNull
    @URL
    private String idPhotoUrl;

    @ApiModelProperty(value="手持证件图片地址",example = "http://")
    @NotNull
    @URL
    private String idPhotoPersonUrl;

    public static MerchantVo make(Merchant merchant, Hr hr) {
        MerchantVo vo = new MerchantVo();

        vo.setMerchantId(merchant.getId());
        vo.setCompanyName(merchant.getCompanyName());
        vo.setTelephone(merchant.getPhone());
        vo.setIdPhotoUrl(merchant.getIdPhotoUrl());
        vo.setIdPhotoPersonUrl(merchant.getIdPhotoPersonUrl());

        vo.setHrId(hr.getId());
        vo.setPhone(hr.getPhone());
        vo.setRealName(hr.getRealName());
        vo.setIdCard(hr.getIdCard());

        return vo;
    }
}
