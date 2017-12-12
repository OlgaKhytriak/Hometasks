package com.epam.finalproject;


import org.apache.log4j.Logger;


public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		ProjectFacade facade = new ProjectFacade();
		facade.createXMLFile();
		facade.validateXML2XSD();
		facade.getObjectBySAX();
	}
	
	

}
