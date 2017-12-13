package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.models.Tariff;

public class Director {
private SingleTariffBuilder builder;

public void setBuilder(SingleTariffBuilder builder) {
	this.builder = builder;
}

public Tariff getTariff() {
	return builder.getTariff();
}

public void constructTariff() {
	builder.createNewTariff();
	builder.buildiD();
	builder.buildName();
	builder.buildOperatorName();
	builder.buildSmsPrice();
	builder.buildParameters();
	builder.buildCallPrices();
}




}
