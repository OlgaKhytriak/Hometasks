package com.epam.finalproject.jdbc.models;

import com.epam.finalproject.jdbc.anotations.Entity;
import com.epam.finalproject.jdbc.anotations.FieldAnn;

@Entity("parameters")
public class ParametersDB extends ModelElement {
	@FieldAnn(value = "id", type = "INT(11)")
	private Integer id;
	@FieldAnn(value = "favourite_numbers", type = "INT(11)")
	private Integer favouriteNumbers;
	@FieldAnn(value = "internet_3g", type = "TINYINT")
	private Boolean internet3G;
	@FieldAnn(value = "home_internet", type = "TINYINT")
	private Boolean homeInternet;

	public ParametersDB() {
	}

	public String toValuesString() {
		return String.format("(%s,%s,%s,%s)", id, favouriteNumbers, internet3G, homeInternet);
	}

	public ParametersDB(int id, Integer favouriteNumbers, Boolean internet3G, Boolean homeInternet) {
		this.id = id;
		this.favouriteNumbers = favouriteNumbers;
		this.internet3G = internet3G;
		this.homeInternet = homeInternet;
	}

	public String toString() {
		return String.format("parameters:: id= %s | favouriteNumbers= %s | internet3G = %s | homeInternet = %s |", id,
				favouriteNumbers, internet3G, homeInternet);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFavouriteNumbers() {
		return favouriteNumbers;
	}

	public void setFavouriteNumbers(Integer favouriteNumbers) {
		this.favouriteNumbers = favouriteNumbers;
	}

	public Boolean getInternet3G() {
		return internet3G;
	}

	public void setInternet3G(Boolean internet3g) {
		internet3G = internet3g;
	}

	public Boolean getHomeInternet() {
		return homeInternet;
	}

	public void setHomeInternet(Boolean homeInternet) {
		this.homeInternet = homeInternet;
	}

	// ------------------------getters and setters------------------------------
	
}
