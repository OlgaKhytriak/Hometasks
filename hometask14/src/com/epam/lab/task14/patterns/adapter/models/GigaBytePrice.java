package com.epam.lab.task14.patterns.adapter.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class GigaBytePrice {
	@XmlElement(required = true, name = "price-name")
	private String priceName;
	@XmlElement(required = true, name = "price-per-gigabyte")
	private double pricePerGig;
	public GigaBytePrice() {
	}

	public GigaBytePrice(String name, double price) {
		super();
		this.priceName = name;
		this.pricePerGig = price;
	}
	public String toString() {
		return String.format(
				"Parameter: name= %s | price = %s ",priceName, pricePerGig);
	}
	public String getName() {
		return priceName;
	}

	public void setName(String name) {
		this.priceName = name;
	}

	public double getPrice() {
		return pricePerGig;
	}

	public void setPrice(double price) {
		this.pricePerGig = price;
	}
}
