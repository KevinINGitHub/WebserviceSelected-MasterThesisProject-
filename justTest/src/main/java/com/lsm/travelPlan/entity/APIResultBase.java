package com.lsm.travelPlan.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "APIResult")
public class APIResultBase {
	List<HotelDetail> hotelDetailList;
	
	List<ScenicDetail> scenicDetail;
	public List<ScenicDetail> getScenicDetail() {
		return scenicDetail;
	}

	public void setScenicDetail(List<ScenicDetail> scenicDetail) {
		this.scenicDetail = scenicDetail;
	}

	
	public List<HotelDetail> getHotelDetailList() {
		return hotelDetailList;
	}

	public void setHotelDetailList(List<HotelDetail> hotelDetailList) {
		this.hotelDetailList = hotelDetailList;
	}
}
