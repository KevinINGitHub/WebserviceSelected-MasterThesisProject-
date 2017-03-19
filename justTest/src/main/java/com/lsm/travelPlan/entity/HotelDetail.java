package com.lsm.travelPlan.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HotelDetail")
public class HotelDetail {
	String name="";
	String province="";
	String address="";
	String objURL="";
	String price="";
	String starLevel="";
	String roomNum="";
	String tel="";
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(String starLevel) {
		this.starLevel = starLevel;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getObjURL() {
		return objURL;
	}
	public void setObjURL(String objURL) {
		this.objURL = objURL;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
