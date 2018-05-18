package com.rias.sharing.life.merchant.service.impl;

import com.rias.sharing.life.merchant.constants.AuditEnum;
import com.rias.sharing.life.merchant.constants.HrStatusEnum;
import com.rias.sharing.life.merchant.dao.AuditInfoDao;
import com.rias.sharing.life.merchant.dao.HrDao;
import com.rias.sharing.life.merchant.dao.MerchantDao;
import com.rias.sharing.life.merchant.entity.AuditInfo;
import com.rias.sharing.life.merchant.entity.Hr;
import com.rias.sharing.life.merchant.entity.Merchant;
import com.rias.sharing.life.merchant.service.JztMerchantService;
import com.rias.sharing.life.merchant.service.aliyun.AcsService;
import com.rias.sharing.life.merchant.vo.MerchantVo;
import com.rias.sharing.life.merchant.vo.TokenQueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:商户服务实现
 * @author:yangyu
 * @date:2018/4/25
 */
@Service
public class JztMerchantServiceImpl implements JztMerchantService {
    private static final Logger logger = LoggerFactory.getLogger(JztMerchantServiceImpl.class);

    @Autowired
    MerchantDao jztMerchantDao;
    @Autowired
    HrDao jztHrDao;
    @Autowired
    AuditInfoDao auditInfoDao;
    @Autowired
    AcsService service;


    @Override
    public MerchantVo getMerchantByPhone(String phone) {
        Hr hr = jztHrDao.getByPhone(phone);

        if (hr == null || null == hr.getMerchantId()) {
            logger.error("Get merchant fail:" + hr);

            throw new RuntimeException(hr.toString());
        }

        Merchant merchant = jztMerchantDao.getById(hr.getMerchantId());

        return MerchantVo.make(merchant, hr);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveJztMerchant(MerchantVo jztMerchantDto){
        Hr hr = new Hr();
        Merchant merchant = new Merchant();

        hr.setIdCard(jztMerchantDto.getIdCard());
        hr.setMerchantId(merchant.getId());
        hr.setStatus(HrStatusEnum.MERCHANT_WAITING_AUDIT.getIndex());
        hr.setPhone(jztMerchantDto.getPhone());
        hr.setRealName(jztMerchantDto.getRealName());

        merchant.setCompanyName(jztMerchantDto.getCompanyName());
        merchant.setIdPhotoPersonUrl(jztMerchantDto.getIdPhotoPersonUrl());
        merchant.setIdPhotoUrl(jztMerchantDto.getIdPhotoUrl());
        merchant.setPhone(jztMerchantDto.getTelephone());
        merchant.setOwnerId(hr.getId());
        merchant.setAuditStatus(AuditEnum.PENDING.getIndex());

        jztHrDao.saveJztHr(hr);
        jztMerchantDao.saveJztMerchant(merchant);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMerchant(MerchantVo jztMerchantDto) {
        Hr hr = new Hr();
        Merchant merchant = new Merchant();

        hr.setId(jztMerchantDto.getHrId());
        hr.setIdCard(jztMerchantDto.getIdCard());
        hr.setPhone(jztMerchantDto.getPhone());
        hr.setRealName(jztMerchantDto.getRealName());

        merchant.setId(jztMerchantDto.getMerchantId());
        merchant.setCompanyName(jztMerchantDto.getCompanyName());
        merchant.setIdPhotoPersonUrl(jztMerchantDto.getIdPhotoPersonUrl());
        merchant.setIdPhotoUrl(jztMerchantDto.getIdPhotoUrl());
        merchant.setPhone(jztMerchantDto.getTelephone());

        jztHrDao.updateHr(hr);
        jztMerchantDao.updateMerchant(merchant);
    }

    @Override
    public void sendCodeByPhone(TokenQueryVo query) {
        //TODO 发送短信验证码loginQuery.getMsgCode
//       boolean rst = service.sendValidateCode(query.getPhone(), query.getMessageCode(), StringUtil.get32UUID());
    }

    @Override
    public List<AuditInfo> getBymerchantId(Long merchantId) {
        return auditInfoDao.getBymerchantId(merchantId);
    }
}
