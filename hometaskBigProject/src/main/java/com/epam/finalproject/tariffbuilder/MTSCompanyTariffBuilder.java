package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.model.CallPrices;
import com.epam.finalproject.xml.model.Parameters;

public class MTSCompanyTariffBuilder extends MTSTariffBuilder {
	@Override
	public void buildiD() {
		tariff.setId(2);
	}

	@Override
	public void buildName() {
		tariff.setTariffName("Company tariff form MTS");
	}

	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(100);
	}

	@Override
	public void buildParameters() {
		Parameters parameters = new Parameters();
		parameters.setParametersId(2);
		parameters.setFavouriteNumbers(20);
		parameters.setHomeInternet(true);
		parameters.setInternet3G(true);
		tariff.setParameters(parameters);
	}

	@Override
	public void buildCallPrices() {
		CallPrices callPrices = new CallPrices();
		callPrices.setCallPriceId(2);
		callPrices.setInsideNetwork(10);
		callPrices.setOutsideNetwork(10);
		callPrices.setLandlinePhone(100);
		tariff.setCallPrices(callPrices);
	}

}
