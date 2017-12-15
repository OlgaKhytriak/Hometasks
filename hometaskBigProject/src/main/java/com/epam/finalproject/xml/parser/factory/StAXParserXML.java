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

import com.epam.finalproject.xml.model.CallPrices;
import com.epam.finalproject.xml.model.Parameters;
import com.epam.finalproject.xml.model.Tariff;

public class StAXParserXML extends SampleParser {
	private List<Tariff> tariffList = new ArrayList<Tariff>();
	private Tariff tariff;
	private Parameters parameters;
	private CallPrices callPrices;

	private boolean isId = false;
	private boolean isTariffName = false;
	private boolean isOperatorName = false;
	private boolean isSmsPrice = false;
	private boolean isParametersId = false;
	private boolean isFavouriteNumbers = false;
	private boolean isInternet3G = false;
	private boolean isHomeInternet = false;
	private boolean isCallPriceId = false;
	private boolean isInsideNetwork = false;
	private boolean isOutsideNetwork = false;
	private boolean isLandlinePhone = false;

	public List<Tariff> parse(String xmlFilePath) {
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xmlFilePath));
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					setBoolens(qName);
					break;
				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					setFields(characters);
					break;
				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals("tariff")) {
						tariff.setParameters(parameters);
						tariff.setCallPrices(callPrices);
						tariffList.add(tariff);
					}
				}
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return tariffList;
	}

	private void setBoolens(String qName) {
		if (qName.equals("tariff")) {
			tariff = new Tariff();
			parameters = new Parameters();
			callPrices = new CallPrices();
		} else if (qName.equals("tariff-id")) {
			isId = true;
		} else if (qName.equals("tariff-name")) {
			isTariffName = true;
		} else if (qName.equals("operator-name")) {
			isOperatorName = true;
		} else if (qName.equals("sms-price")) {
			isSmsPrice = true;
		} else if (qName.equals("parameters-id")) {
			isParametersId = true;
		} else if (qName.equals("favourite-numbers")) {
			isFavouriteNumbers = true;
		} else if (qName.equals("internet-3g")) {
			isInternet3G = true;
		} else if (qName.equals("home-internet")) {
			isHomeInternet = true;
		} else if (qName.equals("call-prices-id")) {
			isCallPriceId = true;
		} else if (qName.equals("incide-network")) {
			isInsideNetwork = true;
		} else if (qName.equals("outside-network")) {
			isOutsideNetwork = true;
		} else if (qName.equals("landline-phone")) {
			isLandlinePhone = true;
		}
	}

	private void setFields(Characters characters) {
		if (isId) {
			tariff.setId(Integer.parseInt(characters.getData()));
			isId = false;
		} else if (isTariffName) {
			tariff.setTariffName(characters.getData());
			isTariffName = false;
		} else if (isOperatorName) {
			tariff.setOperatorName(characters.getData());
			isOperatorName = false;
		} else if (isSmsPrice) {
			tariff.setSmsPrice(Integer.parseInt(characters.getData()));
			isSmsPrice = false;
		} else if (isParametersId) {
			parameters.setParametersId(Integer.parseInt(characters.getData()));
			isParametersId = false;
		} else if (isFavouriteNumbers) {
			parameters.setFavouriteNumbers(Integer.parseInt(characters.getData()));
			isFavouriteNumbers = false;
		} else if (isInternet3G) {
			parameters.setInternet3G(Boolean.parseBoolean(characters.getData()));
			isInternet3G = false;
		} else if (isHomeInternet) {
			parameters.setHomeInternet(Boolean.parseBoolean(characters.getData()));
			isHomeInternet = false;
		} else if (isCallPriceId) {
			callPrices.setCallPriceId((Integer.parseInt(characters.getData())));
			isCallPriceId = false;
		} else if (isInsideNetwork) {
			callPrices.setInsideNetwork((Integer.parseInt(characters.getData())));
			isInsideNetwork = false;
		} else if (isOutsideNetwork) {
			callPrices.setOutsideNetwork((Integer.parseInt(characters.getData())));
			isOutsideNetwork = false;
		} else if (isLandlinePhone) {
			callPrices.setLandlinePhone((Integer.parseInt(characters.getData())));
			isLandlinePhone = false;
		}
	}

}
