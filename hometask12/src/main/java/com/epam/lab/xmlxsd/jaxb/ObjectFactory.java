package com.epam.lab.xmlxsd.jaxb;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

public class ObjectFactory {

	private final static QName QNAME=new QName(XMLConstants.NULL_NS_URI,"data");
	
	@XmlElementDecl(name="rate")
	public JAXBElement<Rate> createData(Rate value){
	return new JAXBElement<Rate>(QNAME, Rate.class,null,value);
	}
}
