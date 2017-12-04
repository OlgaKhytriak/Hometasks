package com.epam.lab.xmlxsd.models;
/*
 * less 100GB
 * more 100GB
 * more 1000GB
 */
public class RateGigaBytePrice {
	
	public RateGigaBytePrice() {
	}

	public RateGigaBytePrice(String name, double price) {
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
