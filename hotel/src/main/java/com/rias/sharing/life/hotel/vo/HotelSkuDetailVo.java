package com.rias.sharing.life.hotel.vo;

import com.rias.sharing.life.hotel.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @name: HotelSkuDetailVo
 * @author: lucifinier
 * @date: 2018/5/23 15:03
 * @description: TODO
 */
@ApiModel(value="酒店属性",description="酒店模型Vo")
@Data
public class HotelSkuDetailVo {
    @ApiModelProperty(value="ID",example="1")
    private Long id;

    @ApiModelProperty(value="酒店名称",example="炮房1703")
    private String skuName;

    @ApiModelProperty(value="位置编号",example="11")
    private Long regionId;

    @ApiModelProperty(value="地址",example="武汉光谷约炮小区")
    private String address;

    @ApiModelProperty(value="酒店位置经度，单位0.000001",example="131000000")
    private Integer lng;

    @ApiModelProperty(value="酒店位置维度，单位0.000001",example="131000000")
    private Integer lat;

    @ApiModelProperty(value="商户id",example="1")
    private Long merchantId;

    @ApiModelProperty(value="房间首日价格 单位0.01元",example="20000")
    private Integer roomPrice;

    @ApiModelProperty(value="房间押金 单位0.01元",example="10000")
    private Integer roomBond;

    @ApiModelProperty(value="房间总状态",example="1")
    private Integer roomStatus;

    @ApiModelProperty(value="是否上架",example="1")
    private Boolean onSale;

    @ApiModelProperty(value="标签id",example="1")
    private Long tagId;

    @ApiModelProperty(value="图片地址")
    private List<String> imgUrls;

    @ApiModelProperty(value="设备编号")
    private List<Long> facilities;

    @ApiModelProperty(value="入住日期")
    private List<LocalDate> dates;

    @ApiModelProperty(value="房间日状态")
    private List<Integer> statuses;

    @ApiModelProperty(value="房间日价格")
    private List<Integer> prices;

    public static HotelSkuDetailVo make(LocalDate startDate, LocalDate endDate,
            HotelSku sku, List<HotelSkuImg> imgs, List<HotelSkuFacility> facilities,
            List<HotelSkuDailyStatus> statuses, List<HotelSkuListingPrice> prices) {
        HotelSkuDetailVo vo = new HotelSkuDetailVo();

        vo.setId(sku.getId());
        vo.setSkuName(sku.getSkuName());
        vo.setRegionId(sku.getRegionId());
        vo.setAddress(sku.getAddress());
        vo.setLng(sku.getLng());
        vo.setLat(sku.getLat());
        vo.setMerchantId(sku.getMerchantId());
        vo.setRoomPrice(sku.getRoomPrice());
        vo.setRoomBond(sku.getRoomBond());
        vo.setRoomStatus(sku.getRoomStatus());
        vo.setOnSale(sku.getOnSale());
        vo.setTagId(sku.getTagId());

        // 图片和设备
        vo.setImgUrls(imgs.stream().map(img -> img.getImgUrl()).collect(Collectors.toList()));
        vo.setFacilities(facilities.stream().map(facility -> facility.getFacilityId()).collect(Collectors.toList()));

        // 日期-状态
        Map<LocalDate, Integer> dateStatus = new HashMap<>();
        statuses.stream().forEach(status -> dateStatus.put(status.getDate(), status.getStatus()));

        // 日期-价格
        Map<LocalDate, Integer> datePrice = new HashMap<>();
        prices.stream().forEach(price -> datePrice.put(price.getDate(), price.getPrice()));

        vo.setDates(new ArrayList<>());
        vo.setStatuses(new ArrayList<>());
        vo.setPrices(new ArrayList<>());
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            LocalDate temp = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
            vo.getDates().add(temp);

            // 添加每日房态
            if (dateStatus.containsKey(temp)) {
                vo.getStatuses().add(dateStatus.get(temp));
            } else {
                vo.getStatuses().add(sku.getRoomStatus());
            }

            // 添加每日价格
            if (datePrice.containsKey(temp)) {
                vo.getPrices().add(datePrice.get(temp));
            } else {
                vo.getPrices().add(sku.getRoomPrice());
            }
        }

        // 更新首日价格和总状态
        vo.setRoomPrice(vo.getPrices().get(0));
        vo.setRoomStatus(vo.getStatuses().stream()
                .max(Integer::compareTo).get());

        return vo;
    }
}
