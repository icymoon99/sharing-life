package com.rias.sharing.life.merchant.vo;

import com.rias.sharing.life.merchant.entity.Hr;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="用户",description="用户")
@Data
public class HrVo {
    @ApiModelProperty(value="属性ID",example="1")
    private Long id;

    @ApiModelProperty(value="用户真实姓名",example="杨虎")
    private String realName;

    @ApiModelProperty(value="电话",example="13545139270")
    private String phone;

    @ApiModelProperty(value="商户ID",example="1")
    private Long merchantId;

    @ApiModelProperty(value="身份证",example="420582199603681931")
    private String idCard;

    @ApiModelProperty(value="用户状态",example="1")
    private Integer stauts;

    public static HrVo make(Hr hr) {
        HrVo vo = new HrVo();

        vo.setId(hr.getId());
        vo.setPhone(hr.getPhone());
        vo.setMerchantId(hr.getMerchantId());
        vo.setIdCard(hr.getIdCard());
        vo.setRealName(hr.getRealName());
        vo.setStauts(hr.getStatus());

        return vo;
    }
}
