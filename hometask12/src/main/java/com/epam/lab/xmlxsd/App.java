package com.epam.lab.xmlxsd;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.epam.lab.xmlxsd.jaxb.Rate;
import com.epam.lab.xmlxsd.jaxb.JAXBContextProcessor;
import com.epam.lab.xmlxsd.jaxb.GigaBytePrice;
import com.epam.lab.xmlxsd.jaxb.Parameter;
import com.epam.lab.xmlxsd.models.InternetRate;
import com.epam.lab.xmlxsd.parsers.ParserCreator;
import com.epam.lab.xmlxsd.parsers.ParserType;
import com.epam.lab.xmlxsd.parsers.ParserXML;
import com.epam.lab.xmlxsd.validator.XSDValidator;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);
	private static String xsdFilePath = "src/main/resources/internetRate.xsd";
	private static String xmlFilePath = "src/main/resources/internetRate.xml";
	private static String xmlJAXBFilePath = "src/main/resources/internetRateJAXB.xml";

	public static void main(String[] args) throws Exception {
		LOG.info("--- validateExample ---------------------------------");
		validateExample();
		LOG.info("--- parseExample ------------------------------------");
		parseExample();
		LOG.info("--- JAXBExample ------------------------------------");
		JAXBExample();
	}

	public static void validateExample() {
		XSDValidator xsdValidator = new XSDValidator();
		boolean isValid = xsdValidator.validate(xsdFilePath, xmlFilePath);
		if (isValid) {
			LOG.info(String.format("Xml-file [%s] is VALID according to Xsd - scheme [%s] ", xmlFilePath, xmlFilePath));
		} else {
			LOG.info(String.format("Xml-file [%s] is NOT VALID according to [%s] Xsd - scheme", xmlFilePath,
					xmlFilePath));
		}
	}

	public static void parseExample() throws Exception {
		Date startLinked;
		Date finishLinked;
		startLinked = new Date();
		List<InternetRate> internetRatesSAX=performParse(xmlFilePath, ParserType.SAX);
		printList(internetRatesSAX);
		finishLinked = new Date();
		LOG.info(String.format("Time result for SAX: %s", finishLinked.getTime() - startLinked.getTime()));	
		startLinked = new Date();
		List<InternetRate> internetRatesStAX=performParse(xmlFilePath, ParserType.StAX);
		printList(internetRatesStAX);
		finishLinked = new Date();
		LOG.info(String.format("Time result for StAX: %s", finishLinked.getTime() - startLinked.getTime()));	
		startLinked = new Date();
		List<InternetRate> internetRatesDOM=performParse(xmlFilePath, ParserType.DOM);
		printList(internetRatesDOM);
		finishLinked = new Date();
		LOG.info(String.format("Time result for DOM: %s", finishLinked.getTime() - startLinked.getTime()));	
	}
	
	public static void  JAXBExample() throws JAXBException {
		//JAXBContextProcessor jaxbContextProcessor=new JAXBContextProcessor();
		Rate rate = createRateForJAXB();
		System.out.println("+-+-+-+-"+rate.toString());
		String packagePath = rate.getClass().getPackage().getName();
		JAXBContext jaxbContext = JAXBContext.newInstance(packagePath);
		
		Marshaller marshaller=jaxbContext.createMarshaller();
		Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
		File file=new File(xmlJAXBFilePath);
		marshaller.marshal(rate, file);
		//jaxbContextProcessor.convertObjectToXML(rate, xmlJAXBFilePath);
	}
	
	private static Rate createRateForJAXB() {
		Rate internateRateForJAXB=new Rate();
		internateRateForJAXB.setName("Simple rate");
		internateRateForJAXB.setProviderName("Kyivstar provider");
		internateRateForJAXB.setSpeed(100.23);
		internateRateForJAXB.setGigaBytePrices(createRateGigaBytePrices());
		internateRateForJAXB.setRateParameters(createRateParameters());
		return internateRateForJAXB;
	}

	private static List<GigaBytePrice> createRateGigaBytePrices(){
		List<GigaBytePrice> prices=new ArrayList<GigaBytePrice>();
		GigaBytePrice price1 =new GigaBytePrice("less 100GB", 222);
		prices.add(price1);
		GigaBytePrice price2 =new GigaBytePrice("more 100GB", 333);
		prices.add(price2);
		GigaBytePrice price3 =new GigaBytePrice("more 1000GB", 333);
		prices.add(price3);	
		return prices;
	}
	
	private static List<Parameter> createRateParameters(){
		List<Parameter> parameters=new ArrayList<Parameter>();
		Parameter param1 =new Parameter("subscriptionFee", 1212);
		parameters.add(param1);
		Parameter param2 =new Parameter("additionalSpeed", 2323);
		parameters.add(param2);
		Parameter param3 =new Parameter("smartTV", 3434);
		parameters.add(param3);	
		Parameter param4 =new Parameter("cableTV", 4545);
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

	public static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element.toString());
		}
	}

}
