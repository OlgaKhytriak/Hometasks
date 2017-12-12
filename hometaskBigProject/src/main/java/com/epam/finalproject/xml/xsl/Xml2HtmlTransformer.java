package com.epam.finalproject.xml.xsl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class Xml2HtmlTransformer {

	public void transform(String xmlFilePath, String xslFilePath, String htmlFilePath) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			File file = new File(htmlFilePath);
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("error in Xml2HtmlTransformer.transform() during file.createNewFile()");
				e.printStackTrace();
			}
			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource(xslFilePath));
			transformer.transform(new javax.xml.transform.stream.StreamSource(xmlFilePath),
					new javax.xml.transform.stream.StreamResult(new FileOutputStream(htmlFilePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
