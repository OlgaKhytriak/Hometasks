package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.models.CallPrices;
import com.epam.finalproject.xml.models.Parameters;

public abstract class KyivstarTariffBuilder extends SingleTariffBuilder {

	@Override
	public void buildOperatorName() {
		tariff.setOperatorName("Kyivstar");

	}

	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(25);
	}

	@Override
	public void buildParameters() {
		Parameters parameters = new Parameters();
		parameters.setFavouriteNumbers(0);
		parameters.setHomeInternet(true);
		parameters.setInternet3G(true);
		tariff.setParameters(parameters);
	}

	@Override
	public void buildCallPrices() {
		CallPrices callPrices = new CallPrices();
		callPrices.setInsideNetwork(55);
		callPrices.setOutsideNetwork(250);
		callPrices.setLandlinePhone(350);
		tariff.setCallPrices(callPrices);
	}
}
