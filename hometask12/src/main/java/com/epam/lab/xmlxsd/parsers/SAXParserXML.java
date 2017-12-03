package com.epam.lab.xmlxsd.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.lab.xmlxsd.models.InternetRate;

public class SAXParserXML extends SampleParser{
	//private List<InternetRate> internetRates;
	private final SAXHandler handler;
	public SAXParserXML() {
		handler = new SAXHandler();
		//internetRates = new ArrayList<InternetRate>();
	}
	
	public List<InternetRate> parse(String xmlFilePath) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = parserFactory.newSAXParser();
			saxParser.parse(xmlFilePath, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Exception in SAXParserXML");
		}
		return  handler.getInternetRates();
	}
}
