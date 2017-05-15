package cn.itrip.beans.vo.hotelroom;
import java.io.Serializable;

/**
 *
 * 查询酒店房间的vo
 * Created by zezhong.shang on 17-5-11.
 */
public class SearchHotelRoomVo implements Serializable{

    private Long hotelId;

    private Integer isBook;

    private Integer isHavingBreakfast;

    private Integer isTimelyResponse;

    private Long roomBedTypeId;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getIsBook() {
        return isBook;
    }

    public void setIsBook(Integer isBook) {
        this.isBook = isBook;
    }

    public Integer getIsHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setIsHavingBreakfast(Integer isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public Integer getIsTimelyResponse() {
        return isTimelyResponse;
    }

    public void setIsTimelyResponse(Integer isTimelyResponse) {
        this.isTimelyResponse = isTimelyResponse;
    }

    public Long getRoomBedTypeId() {
        return roomBedTypeId;
    }

    public void setRoomBedTypeId(Long roomBedTypeId) {
        this.roomBedTypeId = roomBedTypeId;
    }
}
