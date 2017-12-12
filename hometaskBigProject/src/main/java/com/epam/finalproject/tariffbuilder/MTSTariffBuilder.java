package com.epam.finalproject.tariffbuilder;

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

}
