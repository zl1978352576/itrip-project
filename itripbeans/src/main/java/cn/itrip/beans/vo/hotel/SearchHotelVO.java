package cn.itrip.beans.vo.hotel;

import java.io.Serializable;

/**
 *
 * 查询酒店的搜索条件
 * Created by zezhong.shang on 17-5-10.
 */
public class SearchHotelVO implements Serializable {

    private String destination;
    private Integer hotelLevel;
    private String keywords;
    private Long areaId;
    private Double minPrice;
    private Double maxPrice;
    private Long feature;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getFeature() {
        return feature;
    }

    public void setFeature(Long feature) {
        this.feature = feature;
    }
}
