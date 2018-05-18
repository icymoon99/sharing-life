package com.rias.sharing.life.merchant.dao;

import com.rias.sharing.life.merchant.dao.mapper.AuditInfoMapper;
import com.rias.sharing.life.merchant.entity.AuditInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @name: AuditInfoDao
 * @author: lucifinier
 * @date: 2018/5/11 11:01
 * @description: TODO
 */
@Repository
public class AuditInfoDao {
    @Autowired
    AuditInfoMapper mapper;

    public void savaAuditInfo(AuditInfo info) {
        mapper.savaAuditInfo(info);
    }

    public List<AuditInfo> getBymerchantId(Long merchantId) {
        return mapper.getBymerchantId(merchantId);
    }
}
