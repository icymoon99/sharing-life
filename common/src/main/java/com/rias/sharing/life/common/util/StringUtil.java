package com.rias.sharing.life.common.util;

import java.util.UUID;

public class StringUtil {
    /**
     * 获取去掉横线的长度为32的UUID串.
     *
     * @author WuShuicheng.
     * @return uuid.
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
