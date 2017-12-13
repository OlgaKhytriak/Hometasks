package com.epam.finalproject.jdbc.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.jdbc.dao.CallPricesDao;
import com.epam.finalproject.jdbc.dao.Transformer;
import com.epam.finalproject.jdbc.model.CallPricesDB;
import com.epam.finalproject.jdbc.model.ModelElement;

public class CallPricesService {
	private static final Logger LOG = Logger.getLogger(CallPricesService.class);
	protected final Transformer transformer;
	private final CallPricesDao CallPricesDao;

	public CallPricesService() {
		CallPricesDao = new CallPricesDao();
		transformer = new Transformer();
	}

	public void addCallPrices(ModelElement modelElement) throws Exception {
		String tableName = Constants.TABLE_CALL_PRICES;
		CallPricesDao.insertRecord(modelElement, tableName);
	}

	public void deleteCallPrices(Integer id) throws Exception {
		transformer.deleteRowsByID(CallPricesDB.class, id);
	}

	public void deleteTableFromDB() throws Exception {
		String tableName = Constants.TABLE_CALL_PRICES_TEST;
		CallPricesDao.dropTable(tableName);
	}

	public void createTableInDB() throws Exception {
		String tableName = Constants.TABLE_CALL_PRICES_TEST;
		transformer.createTableForInstance(CallPricesDB.class, tableName);
	}

	public List<CallPricesDB> getCallPricessList() throws Exception {
		return transformer.getAllDataList(CallPricesDB.class);
	}

	public List<CallPricesDB> getCallPrices(Integer id) throws Exception {
		List<CallPricesDB> rezList = transformer.getDataListByID(CallPricesDB.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No CallPrices with id = %s", id));
		}
		return rezList;
	}
}
