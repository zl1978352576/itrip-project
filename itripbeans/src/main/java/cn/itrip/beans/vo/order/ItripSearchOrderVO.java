package cn.itrip.beans.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 查询个人订单的搜索条件
 * Created by hanlu on 2017/5/17.
 */
@ApiModel(value = "ItripSearchOrderVO",description = "搜索个人订单VO")
public class ItripSearchOrderVO {

    @ApiModelProperty("[非必填] 订单号")
    private String orderNo;

    @ApiModelProperty("[非必填] 联系人")
    private String linkUserName;

    @ApiModelProperty("[非必填] 预定时间（start）")
    private Date startDate;

    @ApiModelProperty("[非必填] 预定时间（end）")
    private Date endDate;

    @ApiModelProperty("[必填] 页面容量")
    private Integer pageSize;

    @ApiModelProperty("[必填] 页码）")
    private Integer pageNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLinkUserName() {
        return linkUserName;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
