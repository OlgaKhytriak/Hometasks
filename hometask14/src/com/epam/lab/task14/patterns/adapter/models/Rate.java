package com.epam.lab.task14.patterns.adapter.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement
@XmlSeeAlso({Param.class, GigaBytePrice.class})
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "rate")
public class Rate {
	private static Integer idCounter = 0;
	@XmlAttribute
	private Integer id;
	@XmlElement(required = true, name = "name")
	private String name;
	@XmlElement(required = true, name = "provider-name")
	private String providerName;
	@XmlElement(required = true, name = "speed")
	private Double speed;
	@XmlElement
	@XmlElementWrapper(name = "parameters")
	List<Param> params;
	@XmlElement
	@XmlElementWrapper(name = "prices-per-gigabyte")
	List<GigaBytePrice> gigaBytePrices;

	public Rate() {
		idCounter++;
		this.id = idCounter;
	}

	public String toString() {
		return String.format(
				"InternetRate: id= %s | name= %s | providerName = %s | speed = %s | parameters (%s) | gigaBytePrices (%s)",
				id, name, providerName,speed,params.toString(),gigaBytePrices.toString());
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

	public List<Param> getRateParameters() {
		return params;
	}

	public void setRateParameters(List<Param> params) {
		this.params = params;
	}

	public List<GigaBytePrice> getGigaBytePrices() {
		return gigaBytePrices;
	}

	public void setGigaBytePrices(List<GigaBytePrice> gigaBytePrices) {
		this.gigaBytePrices = gigaBytePrices;
	}

}
