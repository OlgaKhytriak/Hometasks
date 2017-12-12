package com.epam.finalproject.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "call-prices")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tariff")
public class Tariff implements Cloneable {

	@XmlElement(required = true, name = "tariff-id")
	private Integer id;
	@XmlElement(required = true, name = "tariff-name")
	private String tariffName;
	@XmlElement(required = true, name = "operator-name")
	private String operatorName;
	@XmlElement(required = true, name = "sms-price")
	private Integer smsPrice;
	@XmlElement (name = "parameters")
	private Parameters parameters;
	@XmlElement(name = "call-prices")
	private CallPrices callPrices;

	public Tariff copy() {
		Tariff tariff = new Tariff();
		tariff.setId(this.id);
		tariff.setTariffName(this.tariffName);
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
		boolean isEquals = this.id.equals(newTariff.getId())&&this.tariffName.equals(newTariff.getTariffName())
				&& this.operatorName.equals(newTariff.getOperatorName())
				&& this.smsPrice.equals(newTariff.getSmsPrice()) && this.parameters.equals(newTariff.getParameters())
				&& this.callPrices.equals(newTariff.getCallPrices());
		return isEquals;

	}

	public String toString() {
		return String.format(
				"tariff: id= %s | name= %s | operatorName = %s | smsPrice = %s |\n parameters: %s | \n callPrices: %s",
				id, tariffName, operatorName, smsPrice, parameters.toString(), callPrices.toString());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id1) {
		this.id = id1;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String name1) {
		this.tariffName = name1;
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

	public void setParameters(Parameters parameters1) {
		this.parameters = parameters1;
	}

	public CallPrices getCallPrices() {
		return callPrices;
	}

	public void setCallPrices(CallPrices callPrices1) {
		this.callPrices = callPrices1;
	}

}
