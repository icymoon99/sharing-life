package com.rias.sharing.life.merchant.dao;

import com.rias.sharing.life.merchant.dao.mapper.HrMapper;
import com.rias.sharing.life.merchant.entity.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @name: JztHrDao
 * @author: lucifinier
 * @date: 2018/5/10 14:37
 * @description: TODO
 */
@Repository
public class HrDao {
    @Autowired
    HrMapper mapper;

    public Hr getById(Long id) {
        return mapper.getById(id);
    }

    public Hr getByPhone(String phone) {
        return mapper.getByPhone(phone);
    }

    public int saveJztHr(Hr hr) {
        return mapper.saveJztHr(hr);
    }

    public void updateHr(Hr hr) {
        mapper.updateHr(hr);
    }
}
