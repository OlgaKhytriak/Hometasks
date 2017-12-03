package com.epam.lab.xmlxsd.parsers;

import java.util.List;

import com.epam.lab.xmlxsd.models.InternetRate;

public interface ParserXML {
	public List<InternetRate> parse(String xmlFilePath);
}
