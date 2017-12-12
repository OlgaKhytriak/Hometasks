package com.epam.finalproject.xml.jaxbadapter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBContextProcessor{
	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public JAXBContextProcessor(Class<?>[] clazzes){
		jaxbContext=null;
		try {
			jaxbContext = JAXBContext.newInstance(clazzes);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("Exceprion in constructor JAXBContextProcessor()");
		}
	}
	public <T> T convertXMLToObject(Class<T> clazz, File file) {
		Object objectromXML = null;
		try {
			unmarshaller = jaxbContext.createUnmarshaller();
			objectromXML = unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in  Object2XmlConverter.load()");
			e.printStackTrace();
		}
		return (T) objectromXML;
	}

	public <T> void convertObjectToXML(File file, T object) {
		System.out.println(object.getClass().getName());
		try {
			marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(object, file);
		} catch (JAXBException e) {
			System.out.println("Exception in Object2XmlConverter.save");
			e.printStackTrace();
		}

	}

}
