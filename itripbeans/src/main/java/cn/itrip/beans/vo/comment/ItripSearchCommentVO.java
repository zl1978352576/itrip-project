package cn.itrip.beans.vo.comment;

/**
 * 查询评论的搜索条件
 * Created by hanlu on 2017/5/10.
 */
public class ItripSearchCommentVO {

    private Long hotelId;
    private Integer isHavingImg;//是否有评论图片（0 无图片 1 有图片）
    private Integer isOk;//是否满意（0：有待改善 1：值得推荐）

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getIsHavingImg() {
        return isHavingImg;
    }

    public void setIsHavingImg(Integer isHavingImg) {
        this.isHavingImg = isHavingImg;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }
}
