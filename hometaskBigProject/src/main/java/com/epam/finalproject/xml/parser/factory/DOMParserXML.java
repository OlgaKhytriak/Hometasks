package com.epam.finalproject.xml.parser.factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.finalproject.xml.model.CallPrices;
import com.epam.finalproject.xml.model.Parameters;
import com.epam.finalproject.xml.model.Tariff;

public class DOMParserXML extends SampleParser {
	private List<Tariff> tariffs = new ArrayList<Tariff>();
	Tariff tariff;
	Parameters parameters;
	CallPrices callPrices;

	private NodeList getNodeList(String xmlFilePath) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(xmlFilePath);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		Node root = document.getDocumentElement();
		NodeList rateList = root.getChildNodes();
		return rateList;
	}

	public List<Tariff> parse(String xmlFilePath) {
		NodeList rateList = getNodeList(xmlFilePath);
		for (int i = 0; i < rateList.getLength(); i++) {
			Node tariffNode = rateList.item(i);
			if (tariffNode.getNodeType() == Node.ELEMENT_NODE) {
				tariff = new Tariff();
				parameters = new Parameters();
				callPrices = new CallPrices();
				Element tariffElement = (Element) tariffNode;
				NodeList tariffInfo = tariffElement.getChildNodes();
				constructTariffs(tariffInfo);
			}
		}
		return tariffs;
	}

	private void constructTariffs(NodeList tariffInfo) {
		for (int j = 0; j < tariffInfo.getLength(); j++) {
			Node infoCurrentTariff = tariffInfo.item(j);
			if (infoCurrentTariff.getNodeType() == Node.ELEMENT_NODE) {
				Element info = (Element) infoCurrentTariff;
				setFields(info);
			}
		}
		tariff.setParameters(parameters);
		tariff.setCallPrices(callPrices);
		tariffs.add(tariff);
	}

	private void setFields(Element info) {
		if (info.getTagName().equals("tariff-id")) {
			tariff.setId(Integer.parseInt(info.getTextContent()));
		} else if (info.getTagName().equals("tariff-name")) {
			tariff.setTariffName(info.getTextContent());
		} else if (info.getTagName().equals("operator-name")) {
			tariff.setOperatorName(info.getTextContent());
		} else if (info.getTagName().equals("sms-price")) {
			tariff.setSmsPrice(Integer.parseInt(info.getTextContent()));
		} else if (info.getTagName().equals("parameters")) {
			setFieldsIfParameters(info);
		} else if (info.getTagName().equals("call-prices")) {
			setFieldsIfCallPrices(info);
		}
	}

	private void setFieldsIfCallPrices(Element info) {
		NodeList nodeList = info.getChildNodes();
		for (int k = 0; k < nodeList.getLength(); k++) {
			Node node = nodeList.item(k);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.getTagName().equals("call-prices-id")) {
					callPrices.setCallPriceId(Integer.parseInt(element.getTextContent()));
				} else if (element.getTagName().equals("incide-network")) {
					callPrices.setInsideNetwork(Integer.parseInt(element.getTextContent()));
				} else if (element.getTagName().equals("outside-network")) {
					callPrices.setOutsideNetwork(Integer.parseInt(element.getTextContent()));
				} else if (element.getTagName().equals("landline-phone")) {
					callPrices.setLandlinePhone(Integer.parseInt(element.getTextContent()));
				}
			}
		}
	}

	private void setFieldsIfParameters(Element info) {
		NodeList nodeList = info.getChildNodes();
		for (int k = 0; k < nodeList.getLength(); k++) {
			Node node = nodeList.item(k);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				if (element.getTagName().equals("parameters-id")) {
					parameters.setParametersId(Integer.parseInt(element.getTextContent()));
				} else if (element.getTagName().equals("favourite-numbers")) {
					parameters.setFavouriteNumbers(Integer.parseInt(element.getTextContent()));
				} else if (element.getTagName().equals("internet-3g")) {
					parameters.setInternet3G(Boolean.parseBoolean(element.getTextContent()));
				} else if (element.getTagName().equals("home-internet")) {
					parameters.setHomeInternet(Boolean.parseBoolean(element.getTextContent()));
				}
			}
		}
	}

	public List<Tariff> getInternetProviders() {
		return tariffs;
	}
}
