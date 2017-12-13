package com.epam.finalproject.xml.jaxbadapter;

import java.io.File;
import java.io.IOException;

import com.epam.finalproject.constants.Constants;
import com.epam.finalproject.tariffbuilder.TriffsBuilder;
import com.epam.finalproject.xml.models.Tariffs;

public class CreaterXML {

	public void create() {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Tariffs.class });
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		TriffsBuilder triffsBuilder = new TriffsBuilder();
		Tariffs tariffs = new Tariffs();
		tariffs = triffsBuilder.build();
		File file = new File(Constants.XML_FILE_PATH_TARIFFS);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("error in CreaterXML.create() during file.createNewFile()");
			e.printStackTrace();
		}
		adapter.save(file, tariffs);
		//Tariffs tariffs2 = adapter.load(file);
		//System.out.println("Created object from XML:");
		//System.out.println(tariffs2.toString());
	}
}
