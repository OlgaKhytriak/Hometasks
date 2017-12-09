package com.epam.lab.task14.patterns.diffrentExamples;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.epam.lab.task14.patterns.adapter.JAXBContextProcessor;
import com.epam.lab.task14.patterns.adapter.Object2XmlAdapter;
import com.epam.lab.task14.patterns.adapter.models.GigaBytePrice;
import com.epam.lab.task14.patterns.adapter.models.Param;
import com.epam.lab.task14.patterns.adapter.models.Rate;
import com.epam.lab.task14.patterns.outerbuilder.MTSFamilyTariffBuilder;
import com.epam.lab.task14.patterns.outerbuilder.models.Tariff;

public class AdapterExamples {
	private BuilderExamples builderExamples=new BuilderExamples();
	
	public void runAdapterJAXBForTariff() throws JAXBException, IOException {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(
				new Class[] { Tariff.class});
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		Tariff mtsFamilyTariff=builderExamples.builtTariff(new MTSFamilyTariffBuilder());
		File file = new File(Constants.XML_JAXB_FILE_PATH_TARIFF);
		file.createNewFile();
		adapter.save(file, mtsFamilyTariff);	
		Tariff tariff = adapter.load(file);
		System.out.println("Created object from XML:");
		System.out.println(tariff.toString());
	}
	
	public void runAdapterJAXBForRate() throws JAXBException, IOException {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(
				new Class[] { Rate.class, Param.class, GigaBytePrice.class });
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		// Object2XmlAdapter adapter = new Object2XmlAdapter(
		// new Class[] { Rate.class, Param.class, GigaBytePrice.class });
		// Object2XmlAdapter adapter = new Object2XmlAdapter(
		// new Class[] { Rate.class});
		Rate rate = createRateForJAXB();
		File file = new File(Constants.XML_JAXB_FILE_PATH_1);
		file.createNewFile();
		adapter.save(file, rate);
		Rate rateLoadede = adapter.load(file);
		System.out.println("Created object:");
		System.out.println(rateLoadede.toString());
	}
	
	private Rate createRateForJAXB() {
		Rate internateRateForJAXB = new Rate();
		internateRateForJAXB.setName("Simple start");
		internateRateForJAXB.setProviderName("MTS provider");
		internateRateForJAXB.setSpeed(100.23);
		List<GigaBytePrice> prices = new ArrayList<GigaBytePrice>();
		prices.add(new GigaBytePrice("less 100GB", 222));
		prices.add(new GigaBytePrice("more 100GB", 333));
		prices.add(new GigaBytePrice("more 1000GB", 444));
		internateRateForJAXB.setGigaBytePrices(prices);
		List<Param> params = new ArrayList<Param>();
		params.add(new Param("subscriptionFee", 1212));
		params.add(new Param("additionalSpeed", 2323));
		params.add(new Param("smartTV", 3434));
		params.add(new Param("cableTV", 4545));
		internateRateForJAXB.setRateParameters(params);
		return internateRateForJAXB;
	}

}
