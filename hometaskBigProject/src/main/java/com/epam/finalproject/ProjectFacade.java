package com.epam.finalproject;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.jdbc.service.GeneralService;
import com.epam.finalproject.sort.Sorter;
import com.epam.finalproject.xml.jaxbadapter.CreaterXML;
import com.epam.finalproject.xml.model.Tariffs;
import com.epam.finalproject.xml.parser.Xml2Object;
import com.epam.finalproject.xml.parser.Xml2ObjectAdapter;
import com.epam.finalproject.xml.validator.XSDValidator;
import com.epam.finalproject.xml.xsl.Xml2HtmlTransformer;
import com.epam.finalproject.xml.xsl.XmlChanger;
import com.epam.finalproject.xml2jdbs.Xml2DB;
import com.epam.finalproject.xml2jdbs.Xml2DBFacade;

public class ProjectFacade {
	private static final Logger LOG = Logger.getLogger(ProjectFacade.class);
	private Xml2Object xml2Object = new Xml2ObjectAdapter();

	public void createXMLFile() {
		CreaterXML createrXML = new CreaterXML();
		createrXML.createTariffsXML();
		LOG.info(String.format("File Constants.XML_FILE_PATH_TARIFFS is created and filled in"));
	}

	public void validateXml2Xsd() {
		XSDValidator validator = new XSDValidator();
		boolean isValid = validator.validate(Constants.XSD_FILE_PATH_TARIFFS, Constants.XML_FILE_PATH_TARIFFS);
		if (isValid) {
			LOG.info(String.format("Xml-file [%s] is VALID according to Xsd - scheme [%s] ",
					Constants.XML_FILE_PATH_TARIFFS, Constants.XSD_FILE_PATH_TARIFFS));
		} else {
			LOG.info(String.format("Xml-file [%s] is NOT VALID according to [%s] Xsd - scheme",
					Constants.XML_FILE_PATH_TARIFFS, Constants.XSD_FILE_PATH_TARIFFS));
		}
	}

	public void getObjectByStAX() {
		System.out.println("---- StAX CREATED TARIFFS OBJECT: -----");
		Tariffs tariffs = xml2Object.loadByStAX(Constants.XML_FILE_PATH_TARIFFS);
		System.out.println(tariffs.toString());
	}

	public void getObjectBySAX() {
		System.out.println("---- SAX CREATED TARIFFS OBJECT: -----");
		Tariffs tariffs = xml2Object.loadBySAX(Constants.XML_FILE_PATH_TARIFFS);
		System.out.println(tariffs.toString());
	}

	public void getObjectByDOM() {
		System.out.println("---- DOM CREATED TARIFFS OBJECT: -----");
		Tariffs tariffs = xml2Object.loadByDOM(Constants.XML_FILE_PATH_TARIFFS);
		System.out.println(tariffs.toString());
	}

	public void createHtml() {
		Xml2HtmlTransformer transformer = new Xml2HtmlTransformer();
		transformer.transform(Constants.XML_FILE_PATH_TARIFFS, Constants.XSL_FILE_PATH_TARIFFS,
				Constants.HTML_FILE_PATH_TARIFFS);
	}

	public void createSortedHtml() {
		Xml2HtmlTransformer transformer = new Xml2HtmlTransformer();
		transformer.transform(Constants.XML_FILE_PATH_TARIFFS, Constants.XSL_SORT_FILE_PATH_TARIFFS,
				Constants.HTML_SORT_FILE_PATH_TARIFFS);
	}

	public void importXML2DB() {
		Xml2DB xml2DB = new Xml2DBFacade();
		xml2DB.save2DB(Constants.XML_FILE_PATH_TARIFFS);
	}
	public void createSortedXML() {
		Sorter sorter = new Sorter();
		Tariffs tariffs = xml2Object.loadBySAX(Constants.XML_FILE_PATH_TARIFFS);
		Tariffs sortedTariffs= sorter.sort(tariffs);
		CreaterXML createrXML = new CreaterXML();
		createrXML.create(Constants.XML_FILE_PATH_TARIFFS_SORTED, sortedTariffs);
	}
	
	public void changeRootElement() {
		XmlChanger xmlChanger = new XmlChanger();
		xmlChanger.change(Constants.XML_FILE_PATH_TARIFFS_SORTED, Constants.XSL_FILE_PATH_TARIFFS_ROOT_CHANGER, Constants.XML_FILE_PATH_TARIFFS_CHANGED_ROOT);
	}
	
	public void clearDB() {
		GeneralService generalService = new GeneralService();
		generalService.dropAllTables();
	}
	
	private static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element.toString());
		}
	}

}
