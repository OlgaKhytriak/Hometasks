package com.epam.finalproject.tariffBuilder;

import com.epam.finalproject.models.CallPrices;
import com.epam.finalproject.models.Parameters;

public class MTSFamilyTariffBuilder extends MTSTariffBuilder {
	@Override
	public void buildiD() {
		tariff.setId(1);
	}

	@Override
	public void buildName() {
		tariff.setTariffName("Family tariff from MTS");
	}

	@Override
	public void buildParameters() {
		Parameters parameters = new Parameters();
		parameters.setFavouriteNumbers(10);
		parameters.setHomeInternet(true);
		parameters.setInternet3G(true);
		tariff.setParameters(parameters);
	}

	@Override
	public void buildCallPrices() {
		CallPrices callPrices = new CallPrices();
		callPrices.setInsideNetwork(10);
		callPrices.setOutsideNetwork(50);
		callPrices.setLandlinePhone(200);
		tariff.setCallPrices(callPrices);
	}

}
