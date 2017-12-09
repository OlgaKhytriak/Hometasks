package com.epam.lab.task14.patterns.outerbuilder;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.outerbuilder.models.Parameter;

public class KyivstarCallAbroadTarrifBuilder extends KyivstarTariffBuilder{

	@Override
	public void buildOperatorName() {
		tariff.setName("Fell free to call abroad from Kyivstar" );
		
	}
	@Override
	public void buildParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter("calls abroad", 200));
		parameters.add(new Parameter("favourite foreign number", 10000));
		parameters.add(new Parameter("unlimit 3G", 45000));
		tariff.setParameters(parameters);
		
	}

}
