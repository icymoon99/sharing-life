package com.rias.sharing.life.merchant.dao.mapper;

import com.rias.sharing.life.merchant.entity.Hr;
import org.apache.ibatis.annotations.*;

/**
        * @Description:人力资源dao层
        * @author:yangyu
        * @date:2018/4/23
        */
public interface HrMapper {
    @Select("SELECT * FROM jzt_hr WHERE id=#{id}")
    @Results({
            @Result(property = "realName", column = "real_name"),
            @Result(property = "merchantId", column = "merchant_id"),
            @Result(property = "idCard", column = "id_card"),
    })
    Hr getById(Long id);

    @Select("SELECT * FROM jzt_hr WHERE phone=#{phone}")
    @Results({
            @Result(property = "realName", column = "real_name"),
            @Result(property = "merchantId", column = "merchant_id"),
            @Result(property = "idCard", column = "id_card"),
    })
    Hr getByPhone(String phone);

    @InsertProvider(type=HrProvider.class,method = "saveJztHr")
    int  saveJztHr(Hr hr);

    @UpdateProvider(type=HrProvider.class,method = "updateHr")
    void updateHr(Hr hr);
}
