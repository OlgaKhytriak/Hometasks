package com.epam.lab.xmlxsd.models;

public class InternetRate {
	private static Integer idCounter = 0;
	private Integer id;
	private String name;
	private String providerName;
	private Double subscriptionFee;
	private Double additionalSpeed;
	private Double smartTV;
	private Double cableTV;
	private Double speed;

	public InternetRate() {
		idCounter++;
		this.id = idCounter;
	}

	public String toString() {
		return String.format(
				"InternetRate: id= %s | name= %s | providerName = %s | subscriptionFee = %s | additionalSpeed = %s | smartTV = %s | cableTV = %s | speed = %s ",
				id, name, providerName, subscriptionFee, additionalSpeed, smartTV, cableTV, speed);
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Double getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(Double subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public Double getAdditionalSpeed() {
		return additionalSpeed;
	}

	public void setAdditionalSpeed(Double additionalSpeed) {
		this.additionalSpeed = additionalSpeed;
	}

	public Double getSmartTV() {
		return smartTV;
	}

	public void setSmartTV(Double smartTV) {
		this.smartTV = smartTV;
	}

	public Double getCableTV() {
		return cableTV;
	}

	public void setCableTV(Double cableTV) {
		this.cableTV = cableTV;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

}
