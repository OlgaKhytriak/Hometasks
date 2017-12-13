package com.epam.finalproject.xml.jaxbadapter;

import java.io.File;
import java.io.IOException;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.tariffbuilder.TriffsBuilder;
import com.epam.finalproject.xml.model.Tariffs;

public class CreaterXML {

	public void create(String filePath, Tariffs tariffs) {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Tariffs.class });
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		File file = new File(filePath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("error in CreaterXML.create() during file.createNewFile()");
			e.printStackTrace();
		}
		adapter.save(file, tariffs);
		
	}
	
	public void createTariffsXML() {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Tariffs.class });
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		TriffsBuilder triffsBuilder = new TriffsBuilder();
		Tariffs tariffs = new Tariffs();
		tariffs = triffsBuilder.build();
		create(Constants.XML_FILE_PATH_TARIFFS,  tariffs);
	}
}
