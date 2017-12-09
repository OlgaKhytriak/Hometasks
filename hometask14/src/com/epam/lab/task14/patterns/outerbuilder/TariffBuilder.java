package com.epam.lab.task14.patterns.outerbuilder;

import com.epam.lab.task14.patterns.models.Tariff;

public abstract class TariffBuilder {
	protected Tariff tariff;

	public abstract void buildName();

	public abstract void buildOperatorName();

	public abstract void buildSmsPrice();

	public abstract void buildParameters();

	public abstract void buildCallPrices();

	public Tariff getTariff() {
		return tariff;
	}

	public void createNewTariff() {
		tariff = new Tariff();
	}
}
