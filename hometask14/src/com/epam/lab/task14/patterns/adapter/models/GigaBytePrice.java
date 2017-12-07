package com.epam.lab.task14.patterns.adapter.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class GigaBytePrice {
	@XmlElement(required = true, name = "price-name")
	private String priceName;
	@XmlElement(required = true, name = "price1")
	private double price1;
	public GigaBytePrice() {
	}

	public GigaBytePrice(String name, double price) {
		super();
		this.priceName = name;
		this.price1 = price;
	}
	public String toString() {
		return String.format(
				"Parameter: name= %s | price = %s ",priceName, price1);
	}
	public String getName() {
		return priceName;
	}

	public void setName(String name) {
		this.priceName = name;
	}

	public double getPrice() {
		return price1;
	}

	public void setPrice(double price) {
		this.price1 = price;
	}
}
