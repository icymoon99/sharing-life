package com.rias.sharing.life.merchant.dao.mapper;

import com.rias.sharing.life.merchant.entity.Merchant;
import org.apache.ibatis.annotations.*;

/**
 * @Description:商户dao层
 * @author:yangyu
 * @date:2018/4/23
 */
@Mapper
public interface MerchantMapper {
    @Select("SELECT * FROM merchant WHERE id = #{id}")
    @Results({
            @Result(property = "companyName", column = "company_name"),
            @Result(property = "ownerId", column = "owner_id"),
            @Result(property = "auditorId", column = "auditor_id"),
            @Result(property = "auditStatus", column = "audit_status"),
            @Result(property = "companyName", column = "company_ame"),
            @Result(property = "idPhotoUrl", column = "id_photo_url"),
            @Result(property = "idPhotoPersonUrl", column = "id_photo_person_url"),
    })
    Merchant getById(Long id);

    @Select("SELECT * FROM merchant WHERE phone = #{phone}")
    Merchant getByPhone(String phone);

    @InsertProvider(type=MerchantProvider.class,method = "saveJztMerchant")
    int saveJztMerchant(Merchant jztMerchant);

    @UpdateProvider(type=MerchantProvider.class,method = "updateMerchant")
    void updateMerchant(Merchant jztMerchant);

}
