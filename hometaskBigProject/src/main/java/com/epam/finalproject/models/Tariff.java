package com.epam.finalproject.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Tariff implements Cloneable {

	@XmlAttribute
	private Integer id;
	@XmlElement(required = true, name = "name")
	private String name;
	@XmlElement(required = true, name = "operator-name")
	private String operatorName;
	@XmlElement(required = true, name = "sms-price")
	private Integer smsPrice;
	@XmlElement
	@XmlElementWrapper(name = "parameters")
	private Parameters parameters;
	@XmlElement
	@XmlElementWrapper(name = "call-prices")
	private CallPrices callPrices;

	public Tariff copy() {
		Tariff tariff = new Tariff();
		tariff.setId(this.id);
		tariff.setName(this.name);
		tariff.setOperatorName(this.operatorName);
		tariff.setSmsPrice(this.smsPrice);
		tariff.setParameters(this.parameters);
		tariff.setCallPrices(this.callPrices);
		return tariff;
	}

	@Override
	public Tariff clone() {
		Object clonedObj = null;
		try {
			clonedObj = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Error in Tariff.clone()");
			e.printStackTrace();
		}
		return (Tariff) clonedObj;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Tariff)) {
			return false;
		}
		Tariff newTariff = (Tariff) object;
		boolean isEquals = this.name.equals(newTariff.getName())
				&& this.operatorName.equals(newTariff.getOperatorName())
				&& this.smsPrice.equals(newTariff.getSmsPrice()) && this.parameters.equals(newTariff.getParameters())
				&& this.callPrices.equals(newTariff.getCallPrices());
		return isEquals;

	}

	public String toString() {
		return String.format(
				"TARIFF: id= %s | name= %s | operatorName = %s | smsPrice = %s |\n parameters: %s | \n callPrices: %s",
				id, name, operatorName, smsPrice, parameters.toString(), callPrices.toString());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getSmsPrice() {
		return smsPrice;
	}

	public void setSmsPrice(Integer smsPrice) {
		this.smsPrice = smsPrice;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public CallPrices getCallPrices() {
		return callPrices;
	}

	public void setCallPrices(CallPrices callPrices) {
		this.callPrices = callPrices;
	}

}
