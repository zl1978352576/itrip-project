package cn.itrip.beans.vo.comment;

import cn.itrip.beans.pojo.ItripComment;

public class ItripSearchCommentVO extends ItripComment {
	private String userCode;  //发表评论的用户的姓名
	private Integer hotelLevel;  //酒店的星级
	private String checkInDate;  //入住时间
	private String roomTitle;  //房型名称
	private String hotelName;  //酒店的名称
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getRoomTitle() {
		return roomTitle;
	}
	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
