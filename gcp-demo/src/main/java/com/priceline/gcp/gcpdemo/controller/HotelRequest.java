package com.priceline.gcp.gcpdemo.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)

public class HotelRequest {


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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return hotelName;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.hotelName = name;
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
	

	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getMinRate() {
		return hotelMinRate;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setMinRate(String hotelMinRate) {
		this.hotelMinRate = hotelMinRate;
	}
	
		/**
		 * Gets the due date string.
		 *
		 * @return the due date string
		 */

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public int getId() {
			return Id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId(int id) {
			Id = id;
		}


}
