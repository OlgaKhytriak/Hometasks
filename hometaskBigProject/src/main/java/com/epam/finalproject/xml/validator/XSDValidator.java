package com.epam.finalproject.xml.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

public class XSDValidator {
	private static final Logger LOG = Logger.getLogger(XSDValidator.class);

	public boolean validate(String xsdFilePath, String xmlFilePath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdFilePath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlFilePath)));
		} catch (IOException | SAXException e) {
			LOG.info("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}
