package com.epam.finalproject;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constants.Constants;
import com.epam.finalproject.xml.jaxbadapter.CreaterXML;
import com.epam.finalproject.xml.validator.XSDValidator;

public class ProjectFacade {
	private static final Logger LOG = Logger.getLogger(ProjectFacade.class);

public void createXMLFile() {
	CreaterXML  createrXML = new CreaterXML();
	createrXML.create();
	LOG.info(String.format("File Constants.XML_FILE_PATH_TARIFFS is created and filled in"));
}

public void validateXML2XSD() {
	XSDValidator validator =new XSDValidator();
	boolean isValid=validator.validate(Constants.XSD_FILE_PATH_TARIFFS, Constants.XML_FILE_PATH_TARIFFS);
	if (isValid) {
		LOG.info(String.format("Xml-file [%s] is VALID according to Xsd - scheme [%s] ", Constants.XML_FILE_PATH_TARIFFS, Constants.XSD_FILE_PATH_TARIFFS));
	} else {
		LOG.info(String.format("Xml-file [%s] is NOT VALID according to [%s] Xsd - scheme", Constants.XML_FILE_PATH_TARIFFS,
				Constants.XSD_FILE_PATH_TARIFFS));
	}
}

private static <T> void printList(List<T> list) {
	for (T element : list) {
		System.out.println(element.toString());
	}
}
}


