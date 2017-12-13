package com.epam.finalproject.xml.parser.factory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.finalproject.xml.model.*;

public class SAXHandler extends DefaultHandler {
	private List<Tariff> tariffs = new ArrayList<Tariff>();
	private String element;

	private Integer id; //"tariff-id"
	private String tariffName;//"tariff-name"
	private String operatorName;//"operator-name"
	private Integer smsPrice;//"sms-price"
	private Integer parametersId; //"parameters-id"
	private Integer favouriteNumbers; //"favourite-numbers"
	private boolean internet3G; //"internet-3g"
	private boolean homeInternet;//"home-internet"
	private Integer callPriceId;//"call-prices-id"
	private Integer insideNetwork;//"incide-network"
	private Integer outsideNetwork;//"outside-network"
	private Integer landlinePhone;//"landline-phone"

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
		if (qName.equals("tariff")) {
			Tariff tariff = new Tariff();
			Parameters parameters = new Parameters(parametersId, favouriteNumbers, internet3G, homeInternet);
			CallPrices callPrices = new CallPrices(callPriceId, insideNetwork, outsideNetwork, landlinePhone);
			tariff.setId(id);
			tariff.setTariffName(tariffName);
			tariff.setOperatorName(operatorName);
			tariff.setSmsPrice(smsPrice);
			tariff.setParameters(parameters);
			tariff.setCallPrices(callPrices);
			tariffs.add(tariff);
		}
		element = "";
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (element.equals("tariff-id")) {
			id = Integer.parseInt(new String(ch, start, length));
		} else if (element.equals("tariff-name")) {
			tariffName = new String(ch, start, length);
		} else if (element.equals("operator-name")) {
			operatorName = new String(ch, start, length);
		} else if (element.equals("sms-price")) {
			smsPrice = Integer.parseInt(new String(ch, start, length));
		} else if (element.equals("parameters-id")) {
			parametersId = Integer.parseInt(new String(ch, start, length));
		} else if (element.equals("favourite-numbers")) {
			favouriteNumbers = Integer.parseInt(new String(ch, start, length));
		} else if (element.equals("internet-3g")) {
			internet3G = Boolean.parseBoolean(new String(ch, start, length));
		} else if (element.equals("home-internet")) {
			homeInternet = Boolean.parseBoolean(new String(ch, start, length));
		} else if (element.equals("call-prices-id")) {
			callPriceId = Integer.parseInt(new String(ch, start, length));}
		 else if (element.equals("incide-network")) {
			 insideNetwork= Integer.parseInt(new String(ch, start, length));}
		 else if (element.equals("outside-network")) {
			 outsideNetwork= Integer.parseInt(new String(ch, start, length));}
		 else if (element.equals("landline-phone")) {
			 landlinePhone= Integer.parseInt(new String(ch, start, length));}
	}

	public List<Tariff> getInternetRates() {
		return tariffs;
	}
}
