package com.epam.fivethreads.utils.jaxbadapter;


import com.epam.fivethreads.constant.Constant;
import com.epam.fivethreads.utils.jaxbadapter.model.Letter;
import com.epam.fivethreads.utils.jaxbadapter.model.Letters;
import com.epam.fivethreads.utils.jaxbadapter.model.User;
import com.epam.fivethreads.utils.jaxbadapter.model.Users;

import java.io.File;
import java.io.IOException;

public class CreaterXMLDataFiles {

	public void create(String filePath, Object objToMarshal,JAXBContextProcessor jAXBContextProcessor) {
		Object2XmlAdapter adapter = new Object2XmlAdapter(jAXBContextProcessor);
		File file = new File(filePath);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("error in CreaterXMLDataFiles.create() during file.createNewFile()");
			e.printStackTrace();
		}
		adapter.save(file, objToMarshal);
		
	}
	
	public void createUsersXML() {
		JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Users.class });
       Users users = new Users();
		User user2 = new User("ForHometaskTest@gmail.com","12345aKids");
		User user1=new User("ForHometaskTest1@gmail.com","12345aKids");
        users.add(user1);
        users.add(user2);
		create(Constant.USERS_XML_FILE_PATH,  users,jAXBContextProcessor);
	}


    public void createLettersXML() {
        JAXBContextProcessor jAXBContextProcessor2 = new JAXBContextProcessor(new Class[] { Letters.class});
        Letters letters = new Letters();
        Letter letter1 = new Letter("ForHometaskTest1@gmail.com","Test","Message text. Massage text");
        Letter letter2 = new Letter("ForHometaskTest2@gmail.com","Test","Message text. Massage text");
        letters.add(letter1);
        letters.add(letter2);
        create(Constant.LETTERS_XML_FILE_PATH, letters,jAXBContextProcessor2);
    }
}
