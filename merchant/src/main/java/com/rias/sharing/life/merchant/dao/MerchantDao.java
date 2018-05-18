package com.rias.sharing.life.merchant.dao;

import com.rias.sharing.life.merchant.dao.mapper.MerchantMapper;
import com.rias.sharing.life.merchant.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: JztMerchantDao
 * @author: lucifinier
 * @date: 2018/5/10 14:41
 * @description: TODO
 */
@Repository
public class MerchantDao {
    @Autowired
    private MerchantMapper mapper;

    public Merchant getById(Long id) {
        return mapper.getById(id);
    }

    public Merchant getByPhone(String phone) {
        return mapper.getByPhone(phone);
    }

    public int saveJztMerchant(Merchant merchant) {
        return mapper.saveJztMerchant(merchant);
    }

    public void updateMerchant(Merchant merchant) {
        mapper.updateMerchant(merchant);
    }
}
