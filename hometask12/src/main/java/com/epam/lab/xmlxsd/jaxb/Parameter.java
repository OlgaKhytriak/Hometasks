package com.epam.lab.xmlxsd.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Parameter {

	public Parameter() {
	}

	public Parameter(String name, double price) {
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
