package cn.itrip.beans.vo.hotel;

import cn.itrip.beans.pojo.ItripHotel;

/**
 * Created by zezhong.shang on 17-5-10.
 */
public class ItripHotelVo extends ItripHotel {

    private Double maxPrice;
    private Double minPrice;
    private Integer isOkCount;
    private String extendPropertyIds;
    private String extendPropertyNames;
    private String tradingAreaIds;
    private String tradingAreaNames;
    private Integer commentCount;
    private String featureIds;
    private String featureNames;

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getIsOkCount() {
        return isOkCount;
    }

    public void setIsOkCount(Integer isOkCount) {
        this.isOkCount = isOkCount;
    }

    public String getExtendPropertyIds() {
        return extendPropertyIds;
    }

    public void setExtendPropertyIds(String extendPropertyIds) {
        this.extendPropertyIds = extendPropertyIds;
    }

    public String getExtendPropertyNames() {
        return extendPropertyNames;
    }

    public void setExtendPropertyNames(String extendPropertyNames) {
        this.extendPropertyNames = extendPropertyNames;
    }

    public String getTradingAreaIds() {
        return tradingAreaIds;
    }

    public void setTradingAreaIds(String tradingAreaIds) {
        this.tradingAreaIds = tradingAreaIds;
    }

    public String getTradingAreaNames() {
        return tradingAreaNames;
    }

    public void setTradingAreaNames(String tradingAreaNames) {
        this.tradingAreaNames = tradingAreaNames;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getFeatureIds() {
        return featureIds;
    }

    public void setFeatureIds(String featureIds) {
        this.featureIds = featureIds;
    }

    public String getFeatureNames() {
        return featureNames;
    }

    public void setFeatureNames(String featureNames) {
        this.featureNames = featureNames;
    }
}
