package com.epam.lab.task14.patterns.innerbuilder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Option {
	@XmlElement(required = true, name = "parameter-name")
	private String parameterName;
	@XmlElement(required = true, name = "parameter-price")
	private double parameterPrice;

	public Option() {
	}

	public Option(String name, double price) {
		super();
		this.parameterName = name;
		this.parameterPrice = price;
	}

	public String toString() {
		return String.format("Parameter: name= %s | price = %s ", parameterName, parameterPrice);
	}

	public String getName() {
		return parameterName;
	}

	public void setName(String name) {
		this.parameterName = name;
	}

	public double getPrice() {
		return parameterPrice;
	}

	public void setPrice(double price) {
		this.parameterPrice = price;
	}
}
