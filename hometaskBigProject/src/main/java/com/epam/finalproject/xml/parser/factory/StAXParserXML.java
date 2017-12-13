package com.epam.finalproject.xml.parser.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.epam.finalproject.xml.model.Tariff;
import com.epam.lab.xmlxsd.models.InternetRate;

public class StAXParserXML extends SampleParser{
	private List<Tariff> internetRates = new ArrayList<Tariff>();
	Tariff internetRate;

	public List<Tariff> parse(String xmlFilePath) {
		boolean isName = false;
		boolean isProviderName = false;
		boolean isSubscriptionFee = false;
		boolean isAdditionalSpeed = false;
		boolean isSmartTV = false;
		boolean isCableTV = false;
		boolean isSpeed = false;
		
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xmlFilePath));
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					if (qName.equals("rate")) {
						internetRate = new InternetRate();
					} else if (qName.equals("name")) {
						isName = true;
					} else if (qName.equals("providerName")) {
						isProviderName = true;
					} else if (qName.equals("subscriptionFee")) {
						isSubscriptionFee = true;
					} else if (qName.equals("additionalSpeed")) {
						isAdditionalSpeed = true;
					} else if (qName.equals("smartTV")) {
						isSmartTV = true;
					} else if (qName.equals("cableTV")) {
						isCableTV = true;
					} else if (qName.equals("speed")) {
						isSpeed = true;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (isName) {
						internetRate.setName(characters.getData());
						isName = false;
					}
					if (isProviderName) {
						internetRate.setProviderName(characters.getData());
						isProviderName = false;
					}
					if (isSubscriptionFee) {
						internetRate.setSubscriptionFee(Double.parseDouble(characters.getData()));
						isSubscriptionFee = false;
					}
					if (isAdditionalSpeed) {
						internetRate.setAdditionalSpeed(Double.parseDouble(characters.getData()));
						isAdditionalSpeed = false;
					}
					if (isSmartTV) {
						internetRate.setSmartTV(Double.parseDouble(characters.getData()));
						isSmartTV = false;
					}
					if (isCableTV) {
						internetRate.setCableTV(Double.parseDouble(characters.getData()));
						isCableTV = false;
					}
					if (isSpeed) {
						internetRate.setSpeed(Double.parseDouble(characters.getData()));
						isSpeed = false;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals("rate")) {
						internetRates.add(internetRate);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	return internetRates;
	}
}
