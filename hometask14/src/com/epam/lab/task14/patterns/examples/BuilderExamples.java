package com.epam.lab.task14.patterns.examples;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.task14.patterns.innerbuilder.MegaBytePrice;
import com.epam.lab.task14.patterns.innerbuilder.Option;
import com.epam.lab.task14.patterns.innerbuilder.RateWithBuilder;
import com.epam.lab.task14.patterns.models.Tariff;
import com.epam.lab.task14.patterns.outerbuilder.Director;
import com.epam.lab.task14.patterns.outerbuilder.KyivstarCallAbroadTarrifBuilder;
import com.epam.lab.task14.patterns.outerbuilder.KyivstarFriendsTarrifBuilder;
import com.epam.lab.task14.patterns.outerbuilder.MTSCompanyTariffBuilder;
import com.epam.lab.task14.patterns.outerbuilder.MTSFamilyTariffBuilder;
import com.epam.lab.task14.patterns.outerbuilder.TariffBuilder;

public class BuilderExamples {
	
	public  void runExampleOuterBuilder() {
		Tariff mtsFamilyTariff=builtTariff(new MTSFamilyTariffBuilder());
		System.out.println(mtsFamilyTariff.toString());
		
		Tariff mtsCompanyTariff=builtTariff(new MTSCompanyTariffBuilder());
		System.out.println(mtsCompanyTariff.toString());
		
		Tariff kyivstarFriendsTariff=builtTariff(new KyivstarFriendsTarrifBuilder());
		System.out.println(kyivstarFriendsTariff.toString());
		
		Tariff kyivstarCallAbroadTariff=builtTariff(new KyivstarCallAbroadTarrifBuilder());
		System.out.println(kyivstarCallAbroadTariff.toString());
	}
	
	public  void runExampleInnerBuilder() {
		builtRate();
	}
	
	public  Tariff builtTariff(TariffBuilder tariffBuilder) {
		Director director = new Director();
		director.setBuilder(tariffBuilder);
		director.constructTariff();		
		return director.getTariff();
	}
	
	private void builtRate() {
		List<Option> options = new ArrayList<Option>();
		options.add(new Option("subscription fee", 1212));
		options.add(new Option("extra speed", 2323));
		options.add(new Option("smart TV", 2323));
		List<MegaBytePrice> price = new ArrayList<MegaBytePrice>();
		price.add(new MegaBytePrice("less 1000MB", 123));
		price.add(new MegaBytePrice("more 1000MB", 456));
		price.add(new MegaBytePrice("more 10000MB", 888));
		RateWithBuilder rate = RateWithBuilder.newBuilder().setName("Simple start").setProviderName("Kyivstar")
				.setSpeed(4567.0).setOptions(options).setMegaBytePrices(price).build();
		RateWithBuilder rate2 = RateWithBuilder.newBuilder().setName("Easy begin").setProviderName("MTS")
				.setSpeed(4567.0).setOptions(options).setMegaBytePrices(price).build();
		System.out.println(rate.toString());
		System.out.println(rate2.toString());

	}
}
