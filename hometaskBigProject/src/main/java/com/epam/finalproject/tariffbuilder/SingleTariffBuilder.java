package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.model.*;

public abstract class SingleTariffBuilder {
	protected Tariff tariff;

	public abstract void buildiD();
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
