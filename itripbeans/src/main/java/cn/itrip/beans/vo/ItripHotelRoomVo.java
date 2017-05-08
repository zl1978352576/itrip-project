package cn.itrip.beans.vo;

import cn.itrip.beans.pojo.ItripHotelRoom;

/**
 * Created by zezhong.shang on 17-4-27.
 */
public class ItripHotelRoomVo extends ItripHotelRoom {

    private String roomBedTypeName;

    public String getRoomBedTypeName() {
        return roomBedTypeName;
    }

    public void setRoomBedTypeName(String roomBedTypeName) {
        this.roomBedTypeName = roomBedTypeName;
    }
}
