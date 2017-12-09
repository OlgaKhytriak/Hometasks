package com.epam.lab.task14.patterns.examples;

import com.epam.lab.task14.patterns.models.Tariff;
import com.epam.lab.task14.patterns.outerbuilder.KyivstarFriendsTarrifBuilder;
import com.epam.lab.task14.patterns.outerbuilder.MTSFamilyTariffBuilder;

public class PrototypeExamples {
public void runCopyExample() {
	BuilderExamples builderExamples = new BuilderExamples();
	Tariff originTariff=builderExamples.builtTariff(new MTSFamilyTariffBuilder());
	System.out.println("-- Origin tariff: --");
	System.out.println(originTariff.toString());
	System.out.println("-- Copy tariff: --");
	Tariff copyTariff = originTariff.copy();
	System.out.println(copyTariff.toString());
}

public void runCloneExample() {
	BuilderExamples builderExamples = new BuilderExamples();
	Tariff originTariff=builderExamples.builtTariff(new KyivstarFriendsTarrifBuilder());
	System.out.println("-- Origin tariff: --");
	System.out.println(originTariff.toString());
	System.out.println("-- Clone tariff: --");
	Tariff cloneTariff = originTariff.clone();
	System.out.println(cloneTariff.toString());
	System.out.println("Is equals result="+originTariff.equals(cloneTariff));
	
}


}
