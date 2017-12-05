package com.epam.lab.xmlxsd.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBContextProcessor {
	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	
	public Unmarshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void convertObjectToXML(Object object,String filePath) {
		File file=new File(filePath);
		createMarshalers(object);
		try {
			marshaller.marshal(object, file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in method convertToXML in JAXBContextProcessor");
		}
	}

	public Object convertXMLToObject(Class<?> clazz, String filePath) {
		File file = new File(filePath);
		JAXBContext jaxbContext;
		Unmarshaller unmarshaller;
		Object objectromXML = null;
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
			unmarshaller = jaxbContext.createUnmarshaller();
			objectromXML = unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in method create in convertXMLToObject");
		}			
		return objectromXML;		
	}
	
	private void createMarshalers(Object object) {
		String packagePath = object.getClass().getPackage().getName();
		try {
			jaxbContext = JAXBContext.newInstance(packagePath);
			marshaller=jaxbContext.createMarshaller();
			unmarshaller=jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			System.out.println("Exceprion in method create in JAXBContextProcessor");
		}		
	}

		
	

}
