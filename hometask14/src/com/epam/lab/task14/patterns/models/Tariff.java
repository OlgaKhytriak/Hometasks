package com.epam.lab.task14.patterns.models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlSeeAlso({ Parameter.class, CallPrice.class })
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "tariff")
public class Tariff implements Cloneable{
	private static Integer idCounter = 0;
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
	List<Parameter> parameters;
	@XmlElement
	@XmlElementWrapper(name = "call-prices")
	List<CallPrice> callPrices;

	public Tariff copy() {
		//Не копіює id. Присвоює наступне по ліку id
		Tariff tariff = new Tariff();
		tariff.setName(this.name);
		tariff.setOperatorName(this.operatorName);
		tariff.setSmsPrice(this.smsPrice);
		tariff.setParameters(this.parameters);
		tariff.setCallPrices(this.callPrices);
		;
		return tariff;
	}

	@Override
	public Tariff clone() {
		// Клонує разом із значенням id
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

	public Tariff() {
		idCounter++;
		this.id = idCounter;
	}

	public String toString() {
		return String.format(
				"TARIFF: id= %s | name= %s | operatorName = %s | smsPrice = %s |\n parameters: %s | \n callPrices: %s",
				id, name, operatorName, smsPrice, parameters.toString(), callPrices.toString());
	}

	public Integer getId() {
		return id;
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

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	public List<CallPrice> getCallPrices() {
		return callPrices;
	}

	public void setCallPrices(List<CallPrice> callPrices) {
		this.callPrices = callPrices;
	}

}
