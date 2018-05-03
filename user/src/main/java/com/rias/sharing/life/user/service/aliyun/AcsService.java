package com.rias.sharing.life.user.service.aliyun;

public interface AcsService {
    boolean sendValidateCode(String phone, String code, String id);
}
