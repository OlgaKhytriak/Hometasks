package com.epam.lab.task14.patterns;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.epam.lab.task14.patterns.adapter.Object2XmlAdapter;
import com.epam.lab.task14.patterns.adapter.models.GigaBytePrice;
import com.epam.lab.task14.patterns.adapter.models.Parameter;
import com.epam.lab.task14.patterns.adapter.models.Rate;
import com.epam.lab.task14.patterns.builder.MegaBytePrice;
import com.epam.lab.task14.patterns.builder.Option;
import com.epam.lab.task14.patterns.builder.RateWithBuilder;

public class StartApplication {

	private static String xmlJAXBFilePath1 = "internetRateJAXB1.xml";

	public static void main(String[] args) throws Exception {
		System.out.println("--- Builder Example ------------------------------------");
		builtRate();
		System.out.println("--- Adaper Example ------------------------------------");
		adapterJAXB();
	}

	public static void adapterJAXB() throws JAXBException, IOException {
		Object2XmlAdapter adapter = new Object2XmlAdapter(
				new Class[] { Rate.class, Parameter.class, GigaBytePrice.class });
		Rate rate = createRateForJAXB();
		File file = new File(xmlJAXBFilePath1);
		file.createNewFile();
		adapter.save(file, rate);
		Rate rateLoadede = adapter.load(file);
		System.out.println("Created object:");
		System.out.println(rateLoadede.toString());
	}

	private static void builtRate() {
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

	private static Rate createRateForJAXB() {
		Rate internateRateForJAXB = new Rate();
		internateRateForJAXB.setName("Simple start");
		internateRateForJAXB.setProviderName("MTS provider");
		internateRateForJAXB.setSpeed(100.23);
		List<GigaBytePrice> prices = new ArrayList<GigaBytePrice>();
		prices.add(new GigaBytePrice("less 100GB", 222));
		prices.add(new GigaBytePrice("more 100GB", 333));
		prices.add(new GigaBytePrice("more 1000GB", 444));
		internateRateForJAXB.setGigaBytePrices(prices);
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameters.add(new Parameter("subscriptionFee", 1212));
		parameters.add(new Parameter("additionalSpeed", 2323));
		parameters.add(new Parameter("smartTV", 3434));
		parameters.add(new Parameter("cableTV", 4545));
		internateRateForJAXB.setRateParameters(parameters);
		return internateRateForJAXB;
	}
}
