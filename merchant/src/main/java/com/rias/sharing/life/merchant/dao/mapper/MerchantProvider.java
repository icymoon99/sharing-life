package com.rias.sharing.life.merchant.dao.mapper;

import com.rias.sharing.life.merchant.entity.Merchant;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:商户dao层,动态sql
 * @author:yangyu
 * @date:2018/05/04
 */
public class MerchantProvider {
    /**
     *@Description:更新商户信息
     * @author:yangyu
     * @date:2018/05/04
     * @return
     */
    public String updateMerchant(Merchant merchant){
        String sql =  new SQL(){{
            UPDATE("merchant");
            if(!StringUtils.isEmpty(merchant.getCompanyName())){SET("company_name =#{companyName}");}
            if(null != merchant.getOwnerId()){SET("owner_id =#{ownerId}");}
            if(null != merchant.getPhone()){SET("phone =#{phone}");}
            if(null != merchant.getAuditorId()){SET("auditor_id =#{auditorId}");}
            if(null != merchant.getAuditTime()){SET("audit_time =#{auditTime}");}
            if(null != merchant.getAuditStatus()){SET("audit_status =#{auditStatus}");}
            if(!StringUtils.isEmpty(merchant.getIdPhotoUrl())){SET("id_photo_url =#{idPhotoUrl}");}
            if(!StringUtils.isEmpty(merchant.getIdPhotoPersonUrl())){SET("id_photo_person_url =#{idPhotoPersonUrl}");}
            WHERE(" id = #{id}");
        }}.toString();

        return sql;
    }

    public String saveJztMerchant(Merchant merchant) {
        return new SQL(){{
            INSERT_INTO("merchant");
            if (null != merchant.getId()) {
                VALUES("id","#{id}");
            }
            if(null != merchant.getOwnerId()){
                VALUES("owner_id","#{ownerId}");
            }
            if (!StringUtils.isEmpty(merchant.getCompanyName())) {
                VALUES("company_name","#{companyName}");
            }
            if (!StringUtils.isEmpty(merchant.getPhone())) {
                VALUES("telphone","#{phone}");
            }
            if (null != merchant.getAuditorId()) {
                VALUES("auditor_id","#{auditorId}");
            }
            if (null != merchant.getAuditTime()) {
                VALUES("audit_time","auditTime");
            }
            if (null != merchant.getAuditStatus()) {
                VALUES("audit_status","#{auditStatus}");
            }
            if (!StringUtils.isEmpty(merchant.getIdPhotoUrl())) {
                VALUES("id_photo_url","#{idPhotoUrl}");
            }
            if (!StringUtils.isEmpty(merchant.getIdPhotoPersonUrl())) {
                VALUES("id_photo_person_url","#{idPhotoPersonUrl}");
            }
        }}.toString();
    }
}
