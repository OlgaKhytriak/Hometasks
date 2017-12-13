package com.epam.finalproject.xml.xsl;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlChanger {
	public void change(String xmlSourceFilePath, String xslFilePath, String xmlDestinationFilePath) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Source xslDoc = new StreamSource(xslFilePath);
			Source xmlDoc = new StreamSource(xmlSourceFilePath);
			OutputStream xmlFile = new FileOutputStream(xmlDestinationFilePath);
			Transformer trasform = tFactory.newTransformer(xslDoc);
			trasform.transform(xmlDoc, new StreamResult(xmlFile));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
