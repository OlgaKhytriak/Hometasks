package com.epam.lab.xmlxsd.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class GigaBytePrice {
	@XmlElement(required = true, name = "name")
	private String name;
	@XmlElement(required = true, name = "price")
	private double price;
	public GigaBytePrice() {
	}

	public GigaBytePrice(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String toString() {
		return String.format(
				"Parameter: name= %s | price = %s ",name, price);
	}
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
