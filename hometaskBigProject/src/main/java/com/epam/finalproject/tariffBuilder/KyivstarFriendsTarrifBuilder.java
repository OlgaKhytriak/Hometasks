package com.epam.finalproject.tariffBuilder;

import com.epam.finalproject.models.CallPrices;
import com.epam.finalproject.models.Parameters;

public class KyivstarFriendsTarrifBuilder extends KyivstarTariffBuilder {
	@Override
	public void buildiD() {
		tariff.setId(3);
	}

	@Override
	public void buildName() {
		tariff.setTariffName("Friends together from Kyivstar");
	}

	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(10);
	}

	@Override
	public void buildParameters() {
		Parameters parameters = new Parameters();
		parameters.setFavouriteNumbers(12);
		parameters.setHomeInternet(true);
		parameters.setInternet3G(true);
		tariff.setParameters(parameters);
	}

	@Override
	public void buildCallPrices() {
		CallPrices callPrices = new CallPrices();
		callPrices.setInsideNetwork(12);
		callPrices.setOutsideNetwork(350);
		callPrices.setLandlinePhone(550);
		tariff.setCallPrices(callPrices);
	}

}
