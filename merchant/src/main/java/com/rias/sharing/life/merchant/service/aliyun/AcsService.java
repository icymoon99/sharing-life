package com.rias.sharing.life.merchant.service.aliyun;

public interface AcsService {
    boolean sendValidateCode(String phone, String code, String id);
}
