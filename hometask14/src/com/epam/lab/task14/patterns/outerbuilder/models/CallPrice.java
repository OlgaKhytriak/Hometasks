package com.epam.lab.task14.patterns.outerbuilder.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class CallPrice {
	@XmlElement(required = true, name = "call-name")
	private String cName;
	@XmlElement(required = true, name = "call-price")
	private Integer cPrice;
	public CallPrice() {
	}

	public CallPrice(String cName, Integer cPrice) {
		super();
		this.cName = cName;
		this.cPrice = cPrice;
	}
	public String toString() {
		return String.format(
				"Parameter: name= %s | price = %s ",cName, cPrice);
	}
	public String getName() {
		return cName;
	}

	public void setName(String cName) {
		this.cName = cName;
	}

	public Integer getPrice() {
		return cPrice;
	}

	public void setPrice(Integer cPrice) {
		this.cPrice = cPrice;
	}
}
