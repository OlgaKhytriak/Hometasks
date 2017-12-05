package com.epam.lab.xmlxsd.jaxb;

public class GigaBytePrice {
	private String name;
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
