package cn.itrip.beans.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前端输入-修改订单VO
 * Created by donghai on 2017/5/18.
 */
@ApiModel(value = "ItripModifyHotelOrderVO",description = "修改订单VO")
public class ItripModifyHotelOrderVO {

    @ApiModelProperty("[必填，主键]")
    private Long id;
    @ApiModelProperty("[必填，注：接收数字类型] 支付方式(:1:支付宝 2:微信 3:到店付)")
    private Integer payType;
    @ApiModelProperty("[必填，注：房型id]")
    private Long roomId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
