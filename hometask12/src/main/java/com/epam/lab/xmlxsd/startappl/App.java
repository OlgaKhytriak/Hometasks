package com.epam.lab.xmlxsd.startappl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.xmlxsd.models.InternetRate;
import com.epam.lab.xmlxsd.parsers.ParserCreator;
import com.epam.lab.xmlxsd.parsers.ParserType;
import com.epam.lab.xmlxsd.parsers.ParserXML;
import com.epam.lab.xmlxsd.validator.XSDValidator;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);
	private static String xsdFilePath = "src/main/resources/internetRate.xsd";
	private static String xmlFilePath = "src/main/resources/internetRate.xml";

	public static void main(String[] args) throws Exception {
		LOG.info("--- validateExample ---------------------------------");
		validateExample();
		LOG.info("--- parseExample ------------------------------------");
		parseExample();
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
