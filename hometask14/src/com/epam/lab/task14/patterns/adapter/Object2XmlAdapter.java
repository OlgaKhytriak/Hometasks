package com.epam.lab.task14.patterns.adapter;

import java.io.File;

public class Object2XmlAdapter implements Object2Xml {
	private JAXBContextProcessor jAXBContextProcessor;

	public Object2XmlAdapter(Class<?>[] clazzes) {
		jAXBContextProcessor = new JAXBContextProcessor(clazzes);
	}

	@Override
	public <T> T load(File file) {
		Object object = (T) new Object();
		object = jAXBContextProcessor.convertXMLToObject(object.getClass(), file);
		return (T) object;
	}

	@Override
	public <T> void save(File file, T object) {
		jAXBContextProcessor.convertObjectToXML(file, object);
	}

}
