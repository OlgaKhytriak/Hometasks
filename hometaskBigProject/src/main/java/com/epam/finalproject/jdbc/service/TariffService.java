package com.epam.finalproject.jdbc.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.constants.Constants;
import com.epam.finalproject.jdbc.dao.TariffDao;
import com.epam.finalproject.jdbc.models.ModelElement;
import com.epam.finalproject.jdbc.models.TariffDB;

public class TariffService extends BasicService {
	private static final Logger LOG = Logger.getLogger(TariffService.class);

	private final TariffDao tariffDao;

	public TariffService() {
		tariffDao = new TariffDao();
	}

	public void addTariff(ModelElement modelElement) throws Exception {
		String tableName = Constants.TABLE_TARIFF;
		tariffDao.insertRecord(modelElement, tableName);
	}

	public void deleteTariff(Integer id) throws Exception {
		transformer.deleteRowsByID(TariffDB.class, id);
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

	public List<TariffDB> getTariff(Integer id) throws Exception {
		List<TariffDB> rezList = transformer.getDataListByID(TariffDB.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No tariff with id = %s", id));
		}
		return rezList;
	}
}
