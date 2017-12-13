package com.epam.finalproject.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paremeters1")
public class Parameters {
	@XmlElement(required = true, name = "parameters-id")
	private Integer parametersId;
	@XmlElement(required = true, name = "favourite-numbers")
	private Integer favouriteNumbers;
	@XmlElement(required = true, name = "internet-3g")
	private boolean internet3G;
	@XmlElement(required = true, name = "home-internet")
	private boolean homeInternet;

	public Parameters() {
	}

	public Parameters(Integer parametersId,Integer favouriteNumbers, boolean internet3G, boolean homeInternet) {
		super();
		this.parametersId=parametersId;
		this.favouriteNumbers = favouriteNumbers;
		this.internet3G = internet3G;
		this.homeInternet = homeInternet;
	}

	public String toString() {
		return String.format("\nParameter: id = %s | favouriteNumbers = %s | internet3G = %s | homeInternet=%s ",parametersId,
				favouriteNumbers, internet3G, homeInternet);
	}
	public Integer getFavouriteNumbers() {
		return favouriteNumbers;
	}

	public void setFavouriteNumbers(Integer favouriteNumbers) {
		this.favouriteNumbers = favouriteNumbers;
	}
	public boolean isInternet3G() {
		return internet3G;
	}

	public void setInternet3G(boolean internet3g) {
		internet3G = internet3g;
	}

	public boolean isHomeInternet() {
		return homeInternet;
	}

	public void setHomeInternet(boolean homeInternet) {
		this.homeInternet = homeInternet;
	}
	public Integer getParametersId() {
		return parametersId;
	}

	public void setParametersId(Integer parametersId) {
		this.parametersId = parametersId;
	}
	
}
