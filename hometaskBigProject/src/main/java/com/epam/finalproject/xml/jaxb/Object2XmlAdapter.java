package com.epam.finalproject.xml.jaxb;

import java.io.File;

public class Object2XmlAdapter implements Object2Xml {
	private JAXBContextProcessor jAXBContextProcessor;

	/*public Object2XmlAdapter(Class<?>[] clazzes) {
		jAXBContextProcessor = new JAXBContextProcessor(clazzes);
	}
	*/
	public Object2XmlAdapter(JAXBContextProcessor jAXBContextProcessor) {
	this.jAXBContextProcessor = jAXBContextProcessor;
    }
	public <T> T load(File file) {
		Object object = (T) new Object();
		object = jAXBContextProcessor.convertXMLToObject(object.getClass(), file);
		return (T) object;
	}

	public <T> void save(File file, T object) {
		jAXBContextProcessor.convertObjectToXML(file, object);
	}

}
