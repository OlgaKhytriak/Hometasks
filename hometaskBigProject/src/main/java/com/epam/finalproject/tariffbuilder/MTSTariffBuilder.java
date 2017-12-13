package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.model.CallPrices;
import com.epam.finalproject.xml.model.Parameters;

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
