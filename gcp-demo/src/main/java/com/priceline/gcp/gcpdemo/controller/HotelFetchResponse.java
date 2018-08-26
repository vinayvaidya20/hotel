package com.priceline.gcp.gcpdemo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)

public class HotelFetchResponse {


	/** The Id. */
	private int Id;
	
	/** The name. */
	private String hotelName;
	
	/** The description. */
	private String description;
	
	/** The status. */
	private String hotelMinRate;
	private String hotelCity;
	

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}


	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelMinRate() {
		return hotelMinRate;
	}

	public void setHotelMinRate(String hotelMinRate) {
		this.hotelMinRate = hotelMinRate;
	}
	

}
