package com.priceline.gcp.gcpdemo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)

public class HotelRequest {


	/** The Id. */
	private int hotelId;
	
	/** The name. */
	private String hotelName;
	
	/** The description. */
	private String description;
	
	/** The status. */
	private String hotelMinRate;
	private String hotelCity;


	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHotelMinRate() {
		return hotelMinRate;
	}
	public void setHotelMinRate(String hotelMinRate) {
		this.hotelMinRate = hotelMinRate;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	


	

}
