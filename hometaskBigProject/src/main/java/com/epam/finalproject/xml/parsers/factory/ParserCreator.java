package com.epam.finalproject.xml.parsers.factory;

public class ParserCreator {

	public ParserXML create(ParserType parserType) {
		ParserXML parserXML = null;
		if (parserType.equals(ParserType.SAX)) {
			parserXML = new SAXParserXML();
		} else if (parserType.equals(ParserType.StAX)) {
			parserXML = new StAXParserXML();
		} else if (parserType.equals(ParserType.DOM)) {
			parserXML = new DOMParserXML();
		}
		return parserXML;
	}
}
