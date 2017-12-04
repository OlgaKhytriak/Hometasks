package com.epam.lab.xmlxsd.models;

import javax.xml.bind.annotation.XmlElement;

/*
	subscriptionFee;
	additionalSpeed;
	smartTV;
	cableTV;
 */
public class RateParameter {

	public RateParameter() {
	}

	public RateParameter(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	private String name;
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
