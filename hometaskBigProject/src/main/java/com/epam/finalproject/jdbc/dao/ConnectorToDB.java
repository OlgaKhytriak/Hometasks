package com.epam.finalproject.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.epam.finalproject.constant.Constants;

public class ConnectorToDB {	
	private static final Logger LOG = Logger.getLogger(ConnectorToDB.class);
	private Connection connection;

	public Connection connect() {
		try {
			Class.forName(Constants.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			LOG.info("Error: unable to load driver class!");
		}
		String jdbcUrl = Constants.DB_URL;
		String user = Constants.USER;
		String password = Constants.PASS;
		try {
			connection = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {
			LOG.info("Error: unable to connect!");
		}
		return connection;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			LOG.info("Error: unable to close current connection!");
		}
	}

}
