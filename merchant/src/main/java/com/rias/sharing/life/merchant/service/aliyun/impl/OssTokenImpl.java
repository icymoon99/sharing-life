package com.rias.sharing.life.merchant.service.aliyun.impl;

import com.aliyun.oss.ClientException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.rias.sharing.life.merchant.service.aliyun.OssToken;
import com.rias.sharing.life.merchant.vo.OssTokenVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @name: OssTokenImpl
 * @author: lucifinier
 * @date: 2018/4/26 18:07
 * @description: TODO
 */
@Service
public class OssTokenImpl implements OssToken {
    private static final Logger logger = LoggerFactory.getLogger(OssTokenImpl.class);

    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.end-point}")
    private String endpoint;

    @Value("${aliyun.oss.role-arn}")
    private String roleArn;

    @Value("${aliyun.oss.role-session-name}")
    private String roleSessionName;

    final String policy = "{\n" +
            "    \"Version\": \"1\", \n" +
            "    \"Statement\": [\n" +
            "        {\n" +
            "            \"Action\": [\n" +
            "                \"oss:*\"\n" +
            "            ], \n" +
            "            \"Resource\": [\n" +
            "                \"acs:oss:*:*:*\" \n" +
            "            ], \n" +
            "            \"Effect\": \"Allow\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Override
    public OssTokenVo getOssToken() {
        OssTokenVo vo = new OssTokenVo();

        try {
            // Init ACS Client
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);

            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();

            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy);

            final AssumeRoleResponse response = client.getAcsResponse(request);

            vo.setAccessKeyId(response.getCredentials().getAccessKeyId());
            vo.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
            vo.setSecurityToken(response.getCredentials().getSecurityToken());
        } catch (ClientException e) {
            logger.error("create oss token failed:" + e.getRequestId());
            return null;
        } catch (ServerException e) {
            logger.error("create oss token failed.", e);
            return null;
        } catch (com.aliyuncs.exceptions.ClientException e) {
            logger.error("create oss token failed.", e);
            return null;
        }

        return vo;
    }
}
