package com.rias.sharing.life.hotel.gateway.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @name: DateUtil
 * @author: lucifinier
 * @date: 2018/5/16 16:50
 * @description: 日期工具类
 */
public class DateUtil {
    /**
     * @Description: 获取日期列表
     * @author:张磊
     * @date:2018/5/16
     */
    public static List<LocalDate> getDates(LocalDate start, LocalDate end) {
        List<LocalDate> dates = new ArrayList<>();
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            LocalDate temp = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
            dates.add(temp);
        }

        return dates;
    }
}
