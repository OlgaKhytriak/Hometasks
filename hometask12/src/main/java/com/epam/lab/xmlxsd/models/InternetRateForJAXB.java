package com.epam.lab.xmlxsd.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "rate")
public class InternetRateForJAXB {
	private static Integer idCounter = 0;
	@XmlAttribute
	private Integer id;
	@XmlElement(required = true, name = "NAME")
	private String name;
	@XmlElement(required = true, name = "providerName")
	private String providerName;
	@XmlElement(required = true, name = "speed")
	private Double speed;
	@XmlElement
	@XmlElementWrapper(name = "PARAMETERS")
	List<RateParameter> rateParameters;
	@XmlElement
	@XmlElementWrapper(name = "PRICES per gigaByte")
	List<RateGigaBytePrice> gigaBytePrices;

	public InternetRateForJAXB() {
		idCounter++;
		this.id = idCounter;
	}

	public String toString() {
		return String.format(
				"InternetRate: id= %s | name= %s | providerName = %s | speed = %s | parameters (%s) | gigaBytePrices (%s)",
				id, name, providerName,speed,rateParameters.toString(),gigaBytePrices.toString());
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public List<RateParameter> getRateParameters() {
		return rateParameters;
	}

	public void setRateParameters(List<RateParameter> rateParameters) {
		this.rateParameters = rateParameters;
	}

	public List<RateGigaBytePrice> getGigaBytePrices() {
		return gigaBytePrices;
	}

	public void setGigaBytePrices(List<RateGigaBytePrice> gigaBytePrices) {
		this.gigaBytePrices = gigaBytePrices;
	}

}
