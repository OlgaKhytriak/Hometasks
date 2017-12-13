package com.epam.finalproject.xml.parsers;

import com.epam.finalproject.xml.models.Tariffs;

public interface Xml2Object {

	public Tariffs loadByDOM(String xmlFilePath);
	public Tariffs loadBySAX(String xmlFilePath);
	public Tariffs loadByStAX(String xmlFilePath);
}
