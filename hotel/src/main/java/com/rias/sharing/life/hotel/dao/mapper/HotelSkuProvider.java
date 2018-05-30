package com.rias.sharing.life.hotel.dao.mapper;

import com.rias.sharing.life.hotel.entity.HotelSku;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @name: HotelSkuProvider
 * @author: lucifinier
 * @date: 2018/5/26 10:32
 * @description: TODO
 */
public class HotelSkuProvider {
    final static String TABLE_NAME = "hotel_sku";

    final static String COL_ID = "id";
    final static String COL_SKU_NAME = "sku_name";
    final static String COL_REGION_ID = "region_id";
    final static String COL_ADDRESS = "address";
    final static String COL_LNG = "lng";
    final static String COL_LAT = "lat";
    final static String COL_MERCHANT_ID = "merchant_id";
    final static String COL_ROOM_PRICE = "room_price";
    final static String COL_ROOM_BOND = "room_bond";
    final static String COL_ROOM_STSTUS = "room_status";
    final static String COL_ON_SALE = "on_sale";
    final static String COL_TAG_ID = "tag_id";

    final static String PROP_ID = "#{id}";
    final static String PROP_SKU_NAME = "#{skuName}";
    final static String PROP_REGION_ID = "#{regionId}";
    final static String PROP_ADDRESS = "#{address}";
    final static String PROP_LNG = "#{lng}";
    final static String PROP_LAT = "#{lat}";
    final static String PROP_MERCHANT_ID = "#{merchantId}";
    final static String PROP_ROOM_PRICE = "#{roomPrice}";
    final static String PROP_ROOM_BOND = "#{roomBond}";
    final static String PROP_ROOM_STATUS = "#{roomStatus}";
    final static String PROP_ON_SALE = "#{onSale}";
    final static String PROP_TAG_ID = "#{tagId}";

    public String save(HotelSku sku) {
        return new SQL() {{
            INSERT_INTO(TABLE_NAME);
            if (null != sku.getId()) { VALUES(COL_ID, PROP_ID); }
            if (!StringUtils.isEmpty(sku.getSkuName())) { VALUES(COL_SKU_NAME, PROP_SKU_NAME); }
            if (null != sku.getRegionId()) { VALUES(COL_REGION_ID, PROP_REGION_ID); }
            if (!StringUtils.isEmpty(sku.getAddress())) { VALUES(COL_ADDRESS, PROP_ADDRESS); }
            if (null != sku.getLng()) { VALUES(COL_LNG, PROP_LNG); }
            if (null != sku.getLat()) { VALUES(COL_LAT, PROP_LAT); }
            if (null != sku.getMerchantId()) { VALUES(COL_MERCHANT_ID, PROP_MERCHANT_ID); }
            if (null != sku.getRoomPrice()) { VALUES(COL_ROOM_PRICE, PROP_ROOM_PRICE); }
            if (null != sku.getRoomBond()) { VALUES(COL_ROOM_BOND, PROP_ROOM_BOND); }
            if (null != sku.getRoomStatus()) { VALUES(COL_ROOM_STSTUS, PROP_ROOM_STATUS); }
            if (null != sku.getOnSale()) { VALUES(COL_ON_SALE, PROP_ON_SALE); }
            if (null != sku.getTagId()) { VALUES(COL_TAG_ID, PROP_TAG_ID);}
        }}.toString();
    }
}
