package com.epam.lab.xmlxsd.parsers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.lab.xmlxsd.models.Tariff;

public class SAXHandler extends DefaultHandler {
	private List<Tariff> internetRates = new ArrayList<Tariff>();
	private String element;
	private String name;
	private String providerName;
	private Double subscriptionFee;
	private Double additionalSpeed;
	private Double smartTV;
	private Double cableTV;
	private Double speed;

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String names, String localName, String qName, Attributes attributes) throws SAXException {
		element = qName;
	}

	@Override
	public void endElement(String names, String localName, String qName) {
		if (qName.equals("rate")) {
			Tariff internetRate = new Tariff();
			internetRate.setName(name);
			internetRate.setProviderName(providerName);
			internetRate.setSubscriptionFee(subscriptionFee);
			internetRate.setAdditionalSpeed(additionalSpeed);
			internetRate.setSmartTV(smartTV);
			internetRate.setCableTV(cableTV);
			internetRate.setSpeed(speed);
			internetRates.add(internetRate);
		}
		element = "";

	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (element.equals("name")) {
			name = new String(ch, start, length);
		}
		if (element.equals("providerName")) {
			providerName = new String(ch, start, length);
		}
		if (element.equals("subscriptionFee")) {
			subscriptionFee = Double.parseDouble(new String(ch, start, length));
		}
		if (element.equals("additionalSpeed")) {
			additionalSpeed = Double.parseDouble(new String(ch, start, length));
		}
		if (element.equals("smartTV")) {
			smartTV = Double.parseDouble(new String(ch, start, length));
		}
		if (element.equals("cableTV")) {
			cableTV = Double.parseDouble(new String(ch, start, length));
		}
		if (element.equals("speed")) {
			speed = Double.parseDouble(new String(ch, start, length));
		}
	}

	public List<Tariff> getInternetRates() {
		return internetRates;
	}
}
