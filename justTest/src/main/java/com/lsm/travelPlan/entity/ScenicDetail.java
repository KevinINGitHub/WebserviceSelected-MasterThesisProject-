package com.lsm.travelPlan.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ScenicDetail")
public class ScenicDetail {
	String productId="";
	String spotName="";
	String description="";
	String address="";
	String province="";
	String city="";
	String scenicDetail="";
	String imageUrl="";
	String normalPrice="";
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(String normalPrice) {
		this.normalPrice = normalPrice;
	}

	
	public String getScenicDetail() {
		return scenicDetail;
	}
	public void setScenicDetail(String scenicDetail) {
		this.scenicDetail = scenicDetail;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSpotName() {
		return spotName;
	}
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
