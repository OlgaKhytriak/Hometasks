package com.epam.finalproject.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "callPrices1")
public class CallPrices {
	@XmlElement(required = true, name = "incide-network")
	private Integer insideNetwork;
	@XmlElement(required = true, name = "outside-network")
	private Integer outsideNetwork;
	@XmlElement(required = true, name = "landline-phone")
	private Integer landlinePhone;
	
	public CallPrices() {
	}

	public CallPrices(Integer insideNetwork,Integer outsideNetwork,Integer landlinePhone) {
		super();
		this.insideNetwork = insideNetwork;
		this.outsideNetwork = outsideNetwork;
		this.landlinePhone = landlinePhone;
	}
	public String toString() {
		return String.format(
				"\n CallPrices: insideNetwork= %s | outsideNetwork = %s | landlinePhone=%s ",insideNetwork, outsideNetwork,landlinePhone);
	}

	public Integer getInsideNetwork() {
		return insideNetwork;
	}

	public void setInsideNetwork(Integer insideNetwork) {
		this.insideNetwork = insideNetwork;
	}

	public Integer getOutsideNetwork() {
		return outsideNetwork;
	}

	public void setOutsideNetwork(Integer outsideNetwork) {
		this.outsideNetwork = outsideNetwork;
	}

	public Integer getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(Integer landlinePhone) {
		this.landlinePhone = landlinePhone;
	}
	
}
