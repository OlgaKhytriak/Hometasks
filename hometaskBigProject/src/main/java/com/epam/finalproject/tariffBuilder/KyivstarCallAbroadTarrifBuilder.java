package com.epam.finalproject.tariffBuilder;

import com.epam.finalproject.models.CallPrices;
import com.epam.finalproject.models.Parameters;

public class KyivstarCallAbroadTarrifBuilder extends KyivstarTariffBuilder{
	@Override
	public void buildiD() {
		tariff.setId(4);
	}

	@Override
	public void buildName() {
		tariff.setTariffName("Fell free to call abroad from Kyivstar" );
		
	}
	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(150);
	}

	@Override
	public void buildParameters() {
		Parameters parameters = new Parameters();
		parameters.setFavouriteNumbers(0);
		parameters.setHomeInternet(false);
		parameters.setInternet3G(false);
		tariff.setParameters(parameters);
	}

	@Override
	public void buildCallPrices() {
		CallPrices callPrices = new CallPrices();
		callPrices.setInsideNetwork(100);
		callPrices.setOutsideNetwork(100);
		callPrices.setLandlinePhone(300);
		tariff.setCallPrices(callPrices);
	}


}
