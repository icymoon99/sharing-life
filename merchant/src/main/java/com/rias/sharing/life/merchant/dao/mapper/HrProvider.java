package com.rias.sharing.life.merchant.dao.mapper;

import com.rias.sharing.life.merchant.entity.Hr;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @name: HrProvider
 * @author: lucifinier
 * @date: 2018/5/11 14:50
 * @description: TODO
 */
public class HrProvider {
    public String updateHr(Hr hr) {
        return new SQL() {{
            UPDATE("jzt_hr");
            if (!StringUtils.isEmpty(hr.getRealName())) {
                SET("real_name =#{realName}");
            }
            if (!StringUtils.isEmpty(hr.getPhone())) {
                SET("phone =#{phone}");
            }
            if (null != hr.getMerchantId()) {
                SET("merchant_id =#{merchantId}");
            }
            if (!StringUtils.isEmpty(hr.getIdCard())) {
                SET("id_card =#{idCard}");
            }
            if (null != hr.getStatus()) {
                SET("status =#{status}");
            }
            WHERE(" id = #{id}");
        }}.toString();
    }

    public String saveJztHr(Hr hr) {
        return new SQL() {{
            INSERT_INTO("jzt_hr");
            if (null != hr.getId()) {
                VALUES("id", "#{id}");
            }
            if (!StringUtils.isEmpty(hr.getRealName())) {
                VALUES("real_name", "#{realName}");
            }
            if (!StringUtils.isEmpty(hr.getPhone())) {
                VALUES("phone", "#{phone}");
            }
            if (null != hr.getMerchantId()) {
                VALUES("merchant_id", "#{merchantId}");
            }
            if (!StringUtils.isEmpty(hr.getIdCard())) {
                VALUES("id_card", "#{idCard}");
            }
            if (null != hr.getStatus()) {
                VALUES("status", "#{status}");
            }
        }}.toString();
    }
}
