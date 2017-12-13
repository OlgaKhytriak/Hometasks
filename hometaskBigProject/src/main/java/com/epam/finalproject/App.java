package com.epam.finalproject;


import org.apache.log4j.Logger;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		ProjectFacade facade = new ProjectFacade();
		facade.clearDB();
		facade.createXMLFile();
		facade.validateXml2Xsd();
		facade.getObjectBySAX();
		facade.createHtml();
		facade.createSortedHtml();
		facade.importXML2DB();
		facade.createSortedXML();
		facade.changeRootElement();
	}
	
	

}
