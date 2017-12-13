package com.epam.finalproject.jdbc.dao;

import org.apache.log4j.Logger;

public class TariffDao extends BasicDao {
	private static final Logger LOG = Logger.getLogger(TariffDao.class);

	public void setTariffForeignKeys(String maintableName) throws Exception {
		String sqlRequest = "ALTER TABLE " + maintableName
				+ " ADD FOREIGN KEY (parameters_id) REFERENCES parameters (id),"
				+ " ADD FOREIGN KEY (call_prices_id) REFERENCES call_prices (id)";
		setForeignKeys(maintableName, sqlRequest);
	}
	}
