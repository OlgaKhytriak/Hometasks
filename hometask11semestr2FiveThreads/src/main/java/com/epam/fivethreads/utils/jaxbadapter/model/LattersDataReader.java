package com.epam.fivethreads.utils.jaxbadapter.model;

import com.epam.fivethreads.constant.Constant;
import com.epam.fivethreads.utils.jaxbadapter.JAXBContextProcessor;
import com.epam.fivethreads.utils.jaxbadapter.Object2Xml;
import com.epam.fivethreads.utils.jaxbadapter.Object2XmlAdapter;

import java.io.File;

public class LattersDataReader {
    Letters letters;

    public Letters getdata(){
        JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Letters.class});
        Object2Xml xmlAdapter = new Object2XmlAdapter(jAXBContextProcessor);
        letters=new Letters();
        letters=xmlAdapter.load(new File(Constant.LETTERS_XML_FILE_PATH));
        System.out.println(letters.toString());
        return letters;
    }
}
