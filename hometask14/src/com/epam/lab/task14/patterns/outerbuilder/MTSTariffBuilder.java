package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.outerbuilder.models.CallPrice;

public abstract class MTSTariffBuilder extends TariffBuilder{
	
	@Override
	public void buildOperatorName() {
		tariff.setOperatorName("MTS");		
	}
	@Override
	public void buildCallPrices() {
		List<CallPrice> callPrices = new ArrayList<CallPrice>();
		callPrices.add(new CallPrice("inside network calls", 100));
		callPrices.add(new CallPrice("outside network calls", 300));
		callPrices.add(new CallPrice("landline phone calls", 500));
		tariff.setCallPrices(callPrices);
	}

}
