package com.epam.finalproject.xml.parsers.factory;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.finalproject.models.Tariff;

public class SAXParserXML extends SampleParser {
	private final SAXHandler handler;

	public SAXParserXML() {
		handler = new SAXHandler();
	}

	public List<Tariff> parse(String xmlFilePath) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = parserFactory.newSAXParser();
			saxParser.parse(xmlFilePath, handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("Exception in SAXParserXML");
		}
		return handler.getInternetRates();
	}
}
