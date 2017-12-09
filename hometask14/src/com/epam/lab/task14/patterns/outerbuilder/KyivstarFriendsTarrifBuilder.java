package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.outerbuilder.models.Parameter;

public class KyivstarFriendsTarrifBuilder extends KyivstarTariffBuilder{

	@Override
	public void buildOperatorName() {
		tariff.setName("Friends together from Kyivstar");
		
	}
	@Override
	public void buildParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter("friends list", 20000));
		parameters.add(new Parameter("social networks", 10000));
		parameters.add(new Parameter("home internet", 40000));
		tariff.setParameters(parameters);
		
	}

}
