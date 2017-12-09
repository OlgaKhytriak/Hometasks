package com.epam.lab.task14.patterns.outerbuilder.models;

import javax.xml.bind.annotation.XmlElement;

public class Parameter {
	@XmlElement(required = true, name = "parameter-name")
	private String pName;
	@XmlElement(required = true, name = "parameter-price")
	private Integer pPrice;

	public Parameter() {
	}

	public Parameter(String pName, Integer pPrice) {
		super();
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public String toString() {
		return String.format("Parameter: name= %s | price = %s ", pName, pPrice);
	}

	public String getName() {
		return pName;
	}

	public void setName(String pName) {
		this.pName = pName;
	}

	public Integer getPrice() {
		return pPrice;
	}

	public void setPrice(Integer pPrice) {
		this.pPrice = pPrice;
	}
}
