package com.rias.sharing.life.hotel.order.vo;

import com.rias.sharing.life.hotel.order.entity.HotelOrder;
import com.rias.sharing.life.hotel.order.validator.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @name: HotelOrderCreatingVo
 * @author: lucifinier
 * @date: 2018/5/3 19:52
 * @description: TODO
 */
@ApiModel(value="订单模型",description="订单模型")
@Data
public class HotelOrderCreatingVo implements Serializable {
    private static final long serialVersionUID = -7735766356188951273L;

    @ApiModelProperty(value="订单id",example="1")
    @NotNull
    private Long id;

    @ApiModelProperty(value="用户id",example="2")
    @NotNull
    private Long userId;

    @ApiModelProperty(value="房间id",example="3")
    @NotNull
    private Long skuId;

    @ApiModelProperty(value="房间总价",example="5096")
    @NotNull
    private Integer skuPrice;

    @ApiModelProperty(value="押金",example="200")
    @NotNull
    private Integer skuBond;

    @ApiModelProperty(value="开始日期",example="2018-05-01")
    @NotNull
    private String startDate;

    @ApiModelProperty(value="结束日期",example="2018-05-03")
    @NotNull
    private String endDate;

    @ApiModelProperty(value="入住天数",example="3")
    @NotNull
    private String durationsDay;

    @ApiModelProperty(value="入住人姓名",example="张三")
    @NotNull
    private String occupantName;

    @ApiModelProperty(value="入住人身份证",example="420111111111111111")
    @NotNull
    @Length(min = 18, max = 18)
    private String occupantCard;

    @ApiModelProperty(value="入住人电话",example="13711111111")
    @IsMobile
    private String occupantPhone;

    static public HotelOrder make(HotelOrderCreatingVo vo) {
        HotelOrder order = new HotelOrder();

        order.setId(vo.getId());
        order.setUserId(vo.getUserId());
        order.setSkuId(vo.getSkuId());
        order.setSkuPrice(vo.getSkuPrice());
        order.setSkuBond(vo.getSkuBond());
        order.setStartDate(LocalDate.parse(vo.getStartDate()));
        order.setEndDate(LocalDate.parse(vo.getEndDate()));
        order.setDurationsDay(vo.getDurationsDay());
        order.setOccupantName(vo.getOccupantName());
        order.setOccupantCard(vo.getOccupantCard());
        order.setOccupantPhone(vo.getOccupantPhone());

        return order;
    }
}
