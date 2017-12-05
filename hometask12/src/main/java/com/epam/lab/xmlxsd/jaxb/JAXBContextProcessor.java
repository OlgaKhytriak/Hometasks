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
	
	public void convertObjectToXML(Object object,String filePath) {
		File file=new File(filePath);
		createMarshalers(object);
		try {
			marshaller.marshal(object, file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in method convertToXML in JAXBContextProcessor");
		}
	}

	public Object convertXMLToObject(Class clazz, String filePath) {
		Object object=new Object();
		try {
			createMarshalers(clazz.newInstance());
			File file=new File(filePath);
			object= unmarshaller.unmarshal(file);
		} catch (InstantiationException | IllegalAccessException | JAXBException e) {
			System.out.println("Exceprion in method convertXMLToObject in JAXBContextProcessor");

		}
		return object;
		
		
	}
	
	private void createMarshalers(Object object) {
		String packagePath = object.getClass().getPackage().getName();
		try {
			jaxbContext = JAXBContext.newInstance(packagePath);
			System.out.println("+++++++"+jaxbContext.toString());
			marshaller=jaxbContext.createMarshaller();
			unmarshaller=jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			System.out.println("Exceprion in method create in JAXBContextProcessor");
		}		
	}
	
	

}
