package cn.itrip.beans.vo.store;

import java.util.Date;

/**
 * Created by zezhong.shang on 17-5-17.
 */
public class StoreVo {

    private Long roomId;

    private Date date;

    private Integer store;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }
}

