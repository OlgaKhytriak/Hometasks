package com.epam.finalproject.tariffbuilder;

import com.epam.finalproject.xml.models.CallPrices;
import com.epam.finalproject.xml.models.Parameters;

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
