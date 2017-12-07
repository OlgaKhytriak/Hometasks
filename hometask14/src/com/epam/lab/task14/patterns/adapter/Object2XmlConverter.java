package com.epam.lab.task14.patterns.adapter;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.epam.lab.task14.patterns.adapter.models.GigaBytePrice;
import com.epam.lab.task14.patterns.adapter.models.Parameter;
import com.epam.lab.task14.patterns.adapter.models.Rate;

public class Object2XmlConverter implements Object2Xml {
	private JAXBContext jaxbContext;
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	public Object2XmlConverter(Class<?>[] clazzes){
	//public Object2XmlConverter(){
		jaxbContext=null;
		try {
			//jaxbContext = JAXBContext.newInstance(new Class[] {Rate.class,Parameter.class,GigaBytePrice.class});
			jaxbContext = JAXBContext.newInstance(clazzes);
		} catch (JAXBException e) {
			System.out.println("Exceprion in constructor Object2XmlConverter()");
		}
	}

	@Override
	public <T> T load(Class<T> clazz, File file) {
		Object objectromXML = null;
		try {

			unmarshaller = jaxbContext.createUnmarshaller();
			objectromXML = unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in  Object2XmlConverter.load()");
		}
		return (T) objectromXML;

	}

	@Override
	public <T> void save(File file, T object) {
		System.out.println(object.getClass().getName());
		try {
			// jaxbContext = JAXBContext.newInstance(object.getClass());
			marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(object, file);
		} catch (JAXBException e) {
			System.out.println("Exceprion in Object2XmlConverter.save");
		}

	}

}
