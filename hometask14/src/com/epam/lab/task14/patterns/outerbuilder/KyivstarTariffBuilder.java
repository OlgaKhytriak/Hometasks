package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.models.CallPrice;

public abstract class KyivstarTariffBuilder extends TariffBuilder{

	@Override
	public void buildName() {
		tariff.setOperatorName("Kyivstar");
		
	}
	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(10);	
	}

	@Override
	public void buildCallPrices() {
			List<CallPrice> callPrices = new ArrayList<CallPrice>();
			callPrices.add(new CallPrice("inside network calls", 111));
			callPrices.add(new CallPrice("outside network calls", 333));
			callPrices.add(new CallPrice("landline phone calls", 555));
			tariff.setCallPrices(callPrices);
		}
		
	}

