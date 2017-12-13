package com.epam.finalproject.xml.parsers.factory;

import java.util.List;

import com.epam.finalproject.xml.models.Tariff;

public interface ParserXML {
	public List<Tariff> parse(String xmlFilePath);
}
