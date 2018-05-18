package com.rias.sharing.life.merchant.dao.mapper;

import com.rias.sharing.life.merchant.entity.AuditInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @name: AuditInfoMapper
 * @author: lucifinier
 * @date: 2018/5/11 10:57
 * @description: TODO
 */
public interface AuditInfoMapper {
    @Insert("INSERT INTO jzt_audit_info (id,merchant_id,auditor_id,fail_type,fail_info,audit_time) VALUES "
            +"(#{id},#{merchantId},#{auditorId},#{failType},#{failInfo},#{auditTime});")
    void savaAuditInfo(AuditInfo info);

    @Select("SELECT * FROM jzt_audit_info WHERE merchant_id = #{merchantId}")
    @Results({
            @Result(property = "merchantId", column = "merchant_id"),
            @Result(property = "auditorId", column = "auditor_id"),
            @Result(property = "failType", column = "fail_type"),
            @Result(property = "failInfo", column = "fail_info"),
            @Result(property = "auditTime", column = "audit_time")
    })
    List<AuditInfo> getBymerchantId(Long merchantId);
}
