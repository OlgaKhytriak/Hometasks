package com.epam.finalproject.xml.parsers.factory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.epam.finalproject.models.Tariff;

public class DOMParserXML extends SampleParser {
	private List<Tariff> internetRates = new ArrayList<Tariff>();

	public List<Tariff> parse(String xmlFilePath) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFilePath);
			Node root = document.getDocumentElement();
			NodeList rateList = root.getChildNodes();
			for (int i = 0; i < rateList.getLength(); i++) {
				Node rate = rateList.item(i);
				if (rate.getNodeType() == Node.ELEMENT_NODE) {
					Element rateElement = (Element) rate;
					InternetRate internetRate = new InternetRate();
					NodeList rateInfo = rateElement.getChildNodes();
					for (int j = 0; j < rateInfo.getLength(); j++) {
						Node infoCurrentRate = rateInfo.item(j);
						if (infoCurrentRate.getNodeType() == Node.ELEMENT_NODE) {
							Element info = (Element) infoCurrentRate;
							if (info.getTagName().equals("name")) {
								internetRate.setName(info.getTextContent());
							}
							if (info.getTagName().equals("providerName")) {
								internetRate.setProviderName(info.getTextContent());
							}
							if (info.getTagName().equals("subscriptionFee")) {
								internetRate.setSubscriptionFee(Double.parseDouble(info.getTextContent()));
							}
							if (info.getTagName().equals("parameters")) {
								NodeList parameters = info.getChildNodes();
								for (int k = 0; k < parameters.getLength(); k++) {
									Node parametersCurrentRate = parameters.item(k);
									if (parametersCurrentRate.getNodeType() == Node.ELEMENT_NODE) {
										Element parametersInfo = (Element) parametersCurrentRate;
										if (parametersInfo.getTagName().equals("additionalSpeed")) {
											internetRate.setAdditionalSpeed(
													Double.parseDouble(parametersInfo.getTextContent()));
										}
										if (parametersInfo.getTagName().equals("smartTV")) {
											internetRate
													.setSmartTV(Double.parseDouble(parametersInfo.getTextContent()));
										}
										if (parametersInfo.getTagName().equals("cableTV")) {
											internetRate
													.setCableTV(Double.parseDouble(parametersInfo.getTextContent()));
										}
									}
								}
							}
							if (info.getTagName().equals("speed")) {
								internetRate.setSpeed(Double.parseDouble(info.getTextContent()));
								internetRates.add(internetRate);
							}
						}
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Exception in DOMParserXML");
		}
		return internetRates;
	}

	public List<Tariff> getInternetProviders() {
		return internetRates;
	}
}
