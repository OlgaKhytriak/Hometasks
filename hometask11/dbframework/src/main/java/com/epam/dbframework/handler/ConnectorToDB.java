package com.epam.dbframework.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectorToDB {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/univer";
	static final String USER = "root";
	static final String PASS = "123qaz";
	private static final Logger LOG = Logger.getLogger(ConnectorToDB.class);

	private Connection connection;

	public Connection connect() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			LOG.info("Error: unable to load driver class!");
		}
		String jdbcUrl = DB_URL;
		String user = USER;
		String password = PASS;
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
