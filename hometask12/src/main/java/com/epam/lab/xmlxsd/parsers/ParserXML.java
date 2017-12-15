package com.epam.lab.xmlxsd.parsers;

import java.util.List;

import com.epam.lab.xmlxsd.models.Tariff;

public interface ParserXML {
	public List<Tariff> parse(String xmlFilePath);
}
