package com.epam.finalproject.jdbc.model;

import com.epam.finalproject.jdbc.anotation.Entity;
import com.epam.finalproject.jdbc.anotation.EntityField;

@Entity("tariff")
public class TariffDB extends ModelElement {
	@EntityField(value = "id", type = "INT(11)")
	private Integer id;
	@EntityField("tariff_name")
	private String tariffName;
	@EntityField("operator_name")
	private String operatorName;
	@EntityField(value = "sms_price", type = "INT(11)")
	private Integer smsPrice;
	@EntityField(value = "parameters_id", type = "INT(11)")
	private Integer parametersId;
	@EntityField(value = "call_prices_id", type = "INT(11)")
	private Integer callPricesId;

	public TariffDB() {
	}

	public TariffDB(int id, String tariffName, String operatorName, Integer smsPrice, Integer parametersId,
			Integer callPricesId) {
		this.id = id;
		this.tariffName = tariffName;
		this.operatorName = operatorName;
		this.smsPrice = smsPrice;
		this.parametersId = parametersId;
		this.callPricesId = callPricesId;
	}

	@Override
	public String toValuesString() {
		return String.format("(%s,\'%s\',\'%s\',%s,%s,%s)", id, tariffName, operatorName, smsPrice, parametersId,
				callPricesId);
	}

	public String toString() {
		return String.format(
				"Tariff:: id= %s | tariffName= %s | operatorName= %s | smsPrice= %s |parametersId= %s | callPricesId= %s | ",
				id, tariffName, operatorName, smsPrice, parametersId, callPricesId);
	}
	// ------------------------getters and setters------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTariffName() {
		return tariffName;
	}

	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
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

	public Integer getParametersId() {
		return parametersId;
	}

	public void setParametersId(Integer parametersId) {
		this.parametersId = parametersId;
	}

	public Integer getCallPricesId() {
		return callPricesId;
	}

	public void setCallPricesId(Integer callPricesId) {
		this.callPricesId = callPricesId;
	}

	// ----------------------------------------------------------------

}
