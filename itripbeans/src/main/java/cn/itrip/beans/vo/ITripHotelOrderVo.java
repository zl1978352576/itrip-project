package cn.itrip.beans.vo;

public class ITripHotelOrderVo extends ItripHotelOrder{
	
	private String linkUserName;	//旅客的姓名，多个旅客的姓名之间用逗号隔开
	private String hotelName;	//酒店的名称
	private Integer hotelLevel;	//酒店的级别
	private String address;	//酒店的地址
	private String roomBedTypeName;	//酒店床型名称
	private Integer isHavingBreakfast;	//是否包含早餐
	public String getLinkUserName() {
		return linkUserName;
	}

	public void setLinkUserName(String linkUserName) {
		this.linkUserName = linkUserName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getHotelLevel() {
		return hotelLevel;
	}

	public void setHotelLevel(Integer hotelLevel) {
		this.hotelLevel = hotelLevel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoomBedTypeName() {
		return roomBedTypeName;
	}

	public void setRoomBedTypeName(String roomBedTypeName) {
		this.roomBedTypeName = roomBedTypeName;
	}

	public Integer getIsHavingBreakfast() {
		return isHavingBreakfast;
	}

	public void setIsHavingBreakfast(Integer isHavingBreakfast) {
		this.isHavingBreakfast = isHavingBreakfast;
	}
	
	
}
