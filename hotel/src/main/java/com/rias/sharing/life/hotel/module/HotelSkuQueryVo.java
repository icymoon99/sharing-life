package com.rias.sharing.life.hotel.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @name: HotelSkuQueryVo
 * @author: lucifinier
 * @date: 2018/5/23 15:28
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelSkuQueryVo {
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;
}
