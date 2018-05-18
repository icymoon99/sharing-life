package com.rias.sharing.life.merchant.service.aliyun;


import com.rias.sharing.life.merchant.vo.OssTokenVo;

/**
 * @name: OssToken
 * @author: lucifinier
 * @date: 2018/4/26 18:07
 * @description: TODO
 */
public interface OssToken {

    /**
     * @Description:获取oss临时凭证
     * @author:张磊
     * @date:2018/4/27
     */
    OssTokenVo getOssToken();
}
