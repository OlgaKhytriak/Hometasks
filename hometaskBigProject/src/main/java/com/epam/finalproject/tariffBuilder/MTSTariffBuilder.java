package com.epam.finalproject.tariffBuilder;

import com.epam.finalproject.models.CallPrices;
import com.epam.finalproject.models.Parameters;

public abstract class MTSTariffBuilder extends SingleTariffBuilder {
	
	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(50);
	}
	
	@Override
	public void buildOperatorName() {
		tariff.setOperatorName("MTS");
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
		callPrices.setOutsideNetwork(200);
		callPrices.setLandlinePhone(500);
		tariff.setCallPrices(callPrices);
	}
	

}
