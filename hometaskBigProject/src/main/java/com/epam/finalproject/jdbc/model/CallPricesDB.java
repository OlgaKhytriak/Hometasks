package com.epam.finalproject.jdbc.model;

import com.epam.finalproject.jdbc.anotation.Entity;
import com.epam.finalproject.jdbc.anotation.EntityField;

@Entity("call_prices")
public class CallPricesDB extends ModelElement {
	@EntityField(value = "id", type = "INT(11)")
	private Integer id;
	@EntityField(value = "incide_network", type = "INT(11)")
	private Integer insideNetwork;
	@EntityField(value = "outside_network", type = "INT(11)")
	private Integer outsideNetwork;
	@EntityField(value = "landline_phone", type = "INT(11)")
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
