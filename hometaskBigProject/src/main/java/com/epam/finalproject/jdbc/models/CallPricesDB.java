package com.epam.finalproject.jdbc.models;

import com.epam.finalproject.jdbc.anotations.Entity;
import com.epam.finalproject.jdbc.anotations.FieldAnn;

@Entity("call_prices")
public class CallPricesDB extends ModelElement {
	@FieldAnn(value = "id", type = "INT(11)")
	private Integer id;
	@FieldAnn(value = "incide_network", type = "INT(11)")
	private Integer insideNetwork;
	@FieldAnn(value = "outside_network", type = "INT(11)")
	private Integer outsideNetwork;
	@FieldAnn(value = "landline_phone", type = "INT(11)")
	private Integer landlinePhone;

	public CallPricesDB() {
	}

	public String toValuesString() {
		return String.format("(%s,%s,%s,%s)", id, insideNetwork, outsideNetwork, landlinePhone);
	}

	public CallPricesDB(int id, Integer insideNetwork, Integer outsideNetwork, Integer landlinePhone) {
		this.id = id;
		this.insideNetwork = insideNetwork;
		this.outsideNetwork = outsideNetwork;
		this.landlinePhone = landlinePhone;
	}

	public String toString() {
		return String.format("call_prices:: id= %s | insideNetwork= %s | outsideNetwork = %s | landlinePhone = %s |",
				id, insideNetwork, outsideNetwork, landlinePhone);
	}

	// ------------------------getters and setters------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
