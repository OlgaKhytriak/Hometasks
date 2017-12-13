package com.epam.finalproject.xml.parser.factory;

import java.util.List;

import com.epam.finalproject.xml.model.Tariff;

public interface ParserXML {
	public List<Tariff> parse(String xmlFilePath);
}
