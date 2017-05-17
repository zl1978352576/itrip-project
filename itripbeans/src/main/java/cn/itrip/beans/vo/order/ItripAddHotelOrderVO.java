package cn.itrip.beans.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by donghai on 2017/5/16.
 */
@ApiModel(value = "ItripAddHotelOrderVO",description = "生成订单VO")
public class ItripAddHotelOrderVO {

    @ApiModelProperty("[必填，注：接收数字类型] 订单类型(0:旅游产品 1:酒店产品 2：机票产品)")
    private Integer orderType;
    @ApiModelProperty("[必填] 酒店ID")
    private Long hotelId;
    @ApiModelProperty("[必填] 酒店名称")
    private String hotelName;
    @ApiModelProperty("[必填] 房间ID")
    private Long roomId;
    @ApiModelProperty("[必填] 消耗数量")
    private Integer count;
    @ApiModelProperty("[必填] 入住时间")
    private Date checkInDate;
    @ApiModelProperty("[必填] 退房时间")
    private Date checkOutDate;
    @ApiModelProperty("[非必填] 联系手机号")
    private String noticePhone;
    @ApiModelProperty("[非必填] 联系邮箱")
    private String noticeEmail;
    @ApiModelProperty("[非必填] 特殊需求")
    private String specialRequirement;
    @ApiModelProperty("[非必填，注：接收数字类型] 是否需要发票（0：不需要 1：需要）")
    private Integer isNeedInvoice;
    @ApiModelProperty("[非必填，注：接收数字类型] 发票类型（0：个人 1：公司）")
    private Integer invoiceType;
    @ApiModelProperty("[非必填] 发票抬头")
    private String invoiceHead;
    @ApiModelProperty("[非必填] 入住人名称")
    private String linkUserName;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getNoticePhone() {
        return noticePhone;
    }

    public void setNoticePhone(String noticePhone) {
        this.noticePhone = noticePhone;
    }

    public String getNoticeEmail() {
        return noticeEmail;
    }

    public void setNoticeEmail(String noticeEmail) {
        this.noticeEmail = noticeEmail;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    public Integer getIsNeedInvoice() {
        return isNeedInvoice;
    }

    public void setIsNeedInvoice(Integer isNeedInvoice) {
        this.isNeedInvoice = isNeedInvoice;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }
}
