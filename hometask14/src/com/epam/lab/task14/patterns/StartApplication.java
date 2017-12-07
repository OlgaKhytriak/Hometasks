package com.epam.lab.task14.patterns;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.epam.lab.task14.patterns.adapter.Object2XmlConverter;
import com.epam.lab.task14.patterns.adapter.models.GigaBytePrice;
import com.epam.lab.task14.patterns.adapter.models.Parameter;
import com.epam.lab.task14.patterns.adapter.models.Rate;


public class StartApplication {

	private static String xmlJAXBFilePath1 = "internetRateJAXB1.xml";
	public static void main(String[] args) throws Exception {
		System.out.println("--- JAXBExample1 ------------------------------------");
		exampleJAXB();
		//directJAXB();
	}
	
	public static void directJAXB() throws JAXBException, IOException {
		 Marshaller marshaller;
		 Unmarshaller unmarshaller;
		JAXBContext jaxbContext = JAXBContext.newInstance(new Class[] {Rate.class,Parameter.class,GigaBytePrice.class});
		Rate rate = createRateForJAXB();
		File file =new File(xmlJAXBFilePath1);
		file.createNewFile();
		
	}
	
	public static void exampleJAXB() throws JAXBException, Exception {
		
		Object2XmlConverter object2XmlConverter = new Object2XmlConverter(new Class[] {Rate.class,Parameter.class,GigaBytePrice.class});
		//Object2XmlConverter object2XmlConverter = new Object2XmlConverter();

		Rate rate = createRateForJAXB();
		File file =new File(xmlJAXBFilePath1);
		file.createNewFile();
		System.out.println(file.exists());
		object2XmlConverter.save(file , rate);
		Rate rateLoadede=object2XmlConverter.load(Rate.class, file);
		System.out.println("Created object:");
		System.out.println(rateLoadede.toString());		
	}
	
	private static Rate createRateForJAXB() {
		Rate internateRateForJAXB = new Rate();
		internateRateForJAXB.setName("Simple rate");
		internateRateForJAXB.setProviderName("Kyivstar provider");
		internateRateForJAXB.setSpeed(100.23);
		internateRateForJAXB.setGigaBytePrices(createRateGigaBytePrices());
		internateRateForJAXB.setRateParameters(createRateParameters());
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

}
