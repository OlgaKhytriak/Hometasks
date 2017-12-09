package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.models.Parameter;

public class MTSFamilyTariffBuilder extends MTSTariffBuilder {

	@Override
	public void buildName() {
		tariff.setName("Family tariff from MTS");
	}

	@Override
	public void buildSmsPrice() {
		tariff.setSmsPrice(50);
	}

	@Override
	public void buildParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter("favourite number", 120));
		parameters.add(new Parameter("tarrif changing", 10000));
		parameters.add(new Parameter("home internet", 50000));
		tariff.setParameters(parameters);

	}

}
