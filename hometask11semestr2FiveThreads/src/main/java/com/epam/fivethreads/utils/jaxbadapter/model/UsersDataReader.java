package com.epam.fivethreads.utils.jaxbadapter.model;

import com.epam.fivethreads.constant.Constant;
import com.epam.fivethreads.utils.jaxbadapter.JAXBContextProcessor;
import com.epam.fivethreads.utils.jaxbadapter.Object2Xml;
import com.epam.fivethreads.utils.jaxbadapter.Object2XmlAdapter;

import java.io.File;

public class UsersDataReader {
    Users users;

    public Users getdata(){
        JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Users.class});
        Object2Xml xmlAdapter = new Object2XmlAdapter(jAXBContextProcessor);
        users=new Users();
        users=xmlAdapter.load(new File(Constant.USERS_XML_FILE_PATH));
        System.out.println(users.toString());
        return users;
    }
}
