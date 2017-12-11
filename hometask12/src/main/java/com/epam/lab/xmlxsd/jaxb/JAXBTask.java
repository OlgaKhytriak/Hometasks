package com.epam.lab.xmlxsd.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.epam.lab.xmlxsd.models.InternetRate;
import com.epam.lab.xmlxsd.parsers.ParserCreator;
import com.epam.lab.xmlxsd.parsers.ParserType;
import com.epam.lab.xmlxsd.parsers.ParserXML;

public class JAXBTask {
	private static final Logger LOG = Logger.getLogger(JAXBTask.class);
	private static String xmlJAXBFilePath1 = "src/main/resources/rate.xml";
	
	public static void exampleJAXB() throws  JAXBException {
		JAXBContextProcessor jaxbContextProcessor = new JAXBContextProcessor();
		Rate rate = createRateForJAXB();
		jaxbContextProcessor.convertObjectToXML(rate, xmlJAXBFilePath1);
		Object objectFromXML2 = jaxbContextProcessor.convertXMLToObject(Rate.class, xmlJAXBFilePath1);
		Rate reteFromXML2 = (Rate) objectFromXML2;
		System.out.println("Created object:");
		System.out.println(reteFromXML2.toString());		
	}
	
	private static Rate createRateForJAXB() {
		Rate internateRateForJAXB = new Rate();
		internateRateForJAXB.setName("Simple rate");
		internateRateForJAXB.setProviderName("Kyivstar provider");
		internateRateForJAXB.setSpeed(100.23);
		return internateRateForJAXB;
	}
	
	private static List<GigaBytePrice> createRateGigaBytePrices() {
		List<GigaBytePrice> prices = new ArrayList<GigaBytePrice>();
		GigaBytePrice price1 = new GigaBytePrice("less 100GB", 222);
		prices.add(price1);
		GigaBytePrice price2 = new GigaBytePrice("more 100GB", 333);
		prices.add(price2);
		GigaBytePrice price3 = new GigaBytePrice("more 1000GB", 444);
		prices.add(price3);
		return prices;
	}

	private static List<Parameter> createRateParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		Parameter param1 = new Parameter("subscriptionFee", 1212);
		parameters.add(param1);
		Parameter param2 = new Parameter("additionalSpeed", 2323);
		parameters.add(param2);
		Parameter param3 = new Parameter("smartTV", 3434);
		parameters.add(param3);
		Parameter param4 = new Parameter("cableTV", 4545);
		parameters.add(param4);
		return parameters;
	}

	private static List<InternetRate> performParse(String xmlFilePath, ParserType parserType) {
		ParserCreator parserCreator = new ParserCreator();
		ParserXML parserXML = parserCreator.create(parserType);
		List<InternetRate> internetProvidersList = parserXML.parse(xmlFilePath);
		LOG.info(String.format("%s results: -------------", parserXML.getClass().getSimpleName()));
		return internetProvidersList;
	}
}
