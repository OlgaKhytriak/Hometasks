package com.epam.finalproject.jdbc.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.jdbc.dao.ParametersDao;
import com.epam.finalproject.jdbc.dao.Transformer;
import com.epam.finalproject.jdbc.model.ModelElement;
import com.epam.finalproject.jdbc.model.ParametersDB;

public class ParametersService {
	private static final Logger LOG = Logger.getLogger(ParametersService.class);
	private final ParametersDao paramDao;
	private final Transformer transformer;

	public ParametersService() {
		paramDao = new ParametersDao();
		transformer = new Transformer();
	}

	public void addParameters(ModelElement modelElement) throws Exception {
		String tableName = Constants.TABLE_PARAMETERS;
		paramDao.insertRecord(modelElement, tableName);
	}

	public void deleteParameters(Integer id) throws Exception {
		transformer.deleteRowsByID(ParametersDB.class, id);
	}

	public void createTableInDB() throws Exception {
		String tableName = Constants.TABLE_PARAMETERS;
		transformer.createTableForInstance(ParametersDB.class, tableName);
	}

	public void deleteTableFromDB() throws Exception {
		String tableName = Constants.TABLE_PARAMETERS;
		paramDao.dropTable(tableName);
	}

	public List<ParametersDB> getParametersList() throws Exception {
		return transformer.getAllDataList(ParametersDB.class);
	}

	public List<ParametersDB> getParameters(Integer id) throws Exception {
		List<ParametersDB> rezList = transformer.getDataListByID(ParametersDB.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No parameters with id = %s", id));
		}
		return rezList;
	}
}
