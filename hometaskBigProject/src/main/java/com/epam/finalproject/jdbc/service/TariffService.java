package com.epam.finalproject.jdbc.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constant.Constants;
import com.epam.finalproject.jdbc.dao.TariffDao;
import com.epam.finalproject.jdbc.dao.Transformer;
import com.epam.finalproject.jdbc.model.ModelElement;
import com.epam.finalproject.jdbc.model.TariffDB;

public class TariffService{
	private static final Logger LOG = Logger.getLogger(TariffService.class);
	private final Transformer transformer;
	private final TariffDao tariffDao;

	public TariffService() {
		tariffDao = new TariffDao();
		transformer = new Transformer();
	}

	public void addTariff(ModelElement modelElement) throws Exception {
		String tableName = Constants.TABLE_TARIFF;
		tariffDao.insertRecord(modelElement, tableName);
	}

	public void deleteTariff(Integer id) throws Exception {
		transformer.deleteRowsByID(TariffDB.class, id);
	}
	
	public List<TariffDB> getTariff(Integer id) throws Exception {
		List<TariffDB> rezList = transformer.getDataListByID(TariffDB.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No tariff with id = %s", id));
		}
		return rezList;
	}

	public void deleteTableFromDB() throws Exception {
		String tableName = Constants.TABLE_TARIFF_TEST;
		tariffDao.dropTable(tableName);
	}

	public void createTableInDB() throws Exception {
		String tableName = Constants.TABLE_TARIFF_TEST;
		transformer.createTableForInstance(TariffDB.class, tableName);
		tariffDao.setTariffForeignKeys(tableName);
	}

	public List<TariffDB> getTariffsList() throws Exception {
		return transformer.getAllDataList(TariffDB.class);
	}
}
