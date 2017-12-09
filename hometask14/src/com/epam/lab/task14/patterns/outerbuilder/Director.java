package com.epam.lab.task14.patterns.outerbuilder;

import com.epam.lab.task14.patterns.models.Tariff;

public class Director {
private TariffBuilder builder;

public void setBuilder(TariffBuilder builder) {
	this.builder = builder;
}

public Tariff getTariff() {
	return builder.getTariff();
}

public void constructTariff() {
	builder.createNewTariff();
	builder.buildName();
	builder.buildOperatorName();
	builder.buildSmsPrice();
	builder.buildParameters();
	builder.buildCallPrices();
}




}
