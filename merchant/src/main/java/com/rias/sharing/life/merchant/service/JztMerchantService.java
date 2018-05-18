package com.rias.sharing.life.merchant.service;

import com.rias.sharing.life.merchant.entity.AuditInfo;
import com.rias.sharing.life.merchant.vo.MerchantVo;
import com.rias.sharing.life.merchant.vo.TokenQueryVo;

import java.util.List;

/**
 * @Description:商户服务层
 * @author:yangyu
 * @date:2018/4/25
 */
public interface JztMerchantService {
    /**
     * @Description: 根据电话查询商户信息
     * @author:张磊
     * @date:2018/5/11
     */
    MerchantVo getMerchantByPhone(String phone);
    /**
     * @Description:新增商户
     * @author:yangyu
     * @date:2018/4/25
     */
    void saveJztMerchant(MerchantVo merchantVo);

    /**
     * @Description: 更新商户信息
     * @author:张磊
     * @date:2018/5/11
     */
    void updateMerchant(MerchantVo merchantVo);

    /**
     * 发送校验码
     * @param query
     */
    void sendCodeByPhone(TokenQueryVo query);

    /**
     * 获取审核失败实现
     */
    List<AuditInfo> getBymerchantId(Long merchantId);
}
