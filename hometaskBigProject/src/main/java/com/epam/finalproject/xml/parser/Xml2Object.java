package com.epam.finalproject.xml.parser;

import com.epam.finalproject.xml.model.Tariffs;

public interface Xml2Object {

	public Tariffs loadByDOM(String xmlFilePath);
	public Tariffs loadBySAX(String xmlFilePath);
	public Tariffs loadByStAX(String xmlFilePath);
}
