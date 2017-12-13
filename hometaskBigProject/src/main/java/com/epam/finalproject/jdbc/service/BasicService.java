package com.epam.finalproject.jdbc.service;

import com.epam.finalproject.jdbc.dao.*;
import com.epam.finalproject.jdbc.models.*;

public class BasicService {
	protected final Transformer transformer;
	protected final BasicDao basicDao;
	
	public BasicService() {
		transformer = new Transformer();
		basicDao = new BasicDao();
	}
	
	public void addRecord(ModelElement modelElement, String tableName) throws Exception {
		basicDao.insertRecord(modelElement, tableName);
	}
}
