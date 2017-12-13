package com.epam.finalproject.xml.parsers;

import java.util.List;

import com.epam.finalproject.xml.models.*;
import com.epam.finalproject.xml.parsers.factory.*;
import com.epam.finalproject.xml.parsers.factory.ParserType;

public class Xml2ObjectAdapter implements Xml2Object {

	@Override
	public Tariffs loadByDOM(String xmlFilePath) {
		Tariffs tariffs = new Tariffs();
		tariffs.setTariffs(performParse(xmlFilePath, ParserType.DOM));
		return tariffs;
	}

	@Override
	public Tariffs loadBySAX(String xmlFilePath) {
		Tariffs tariffs = new Tariffs();
		tariffs.setTariffs(performParse(xmlFilePath, ParserType.SAX));
		return tariffs;
	}

	@Override
	public Tariffs loadByStAX(String xmlFilePath) {
		Tariffs tariffs = new Tariffs();
		tariffs.setTariffs(performParse(xmlFilePath, ParserType.StAX));
		return tariffs;
	}

	private List<Tariff> performParse(String xmlFilePath, ParserType parserType) {
		ParserCreator parserCreator = new ParserCreator();
		ParserXML parserXML = parserCreator.create(parserType);
		List<Tariff> tariffsList = parserXML.parse(xmlFilePath);
		return tariffsList;
	}
}
