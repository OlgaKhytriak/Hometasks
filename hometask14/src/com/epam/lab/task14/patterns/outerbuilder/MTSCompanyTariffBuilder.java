package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.models.Parameter;

public class MTSCompanyTariffBuilder extends MTSTariffBuilder {

	@Override
	public void buildName() {
		tariff.setName("Company tariff form MTS");
	}

	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(100);
	}

	@Override
	public void buildParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter("corporative number", 20000));
		parameters.add(new Parameter("tarrif changing", 20000));
		parameters.add(new Parameter("fast inlimited internet", 30000));
		parameters.add(new Parameter("additional staff namber", 15000));
		tariff.setParameters(parameters);

	}

}
