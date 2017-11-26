package com.epam.dbframework.service;

import com.epam.dbframework.dao.BasicDao;
import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.ModelElement;

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
