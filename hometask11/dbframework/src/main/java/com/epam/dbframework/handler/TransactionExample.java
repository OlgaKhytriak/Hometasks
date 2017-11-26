package com.epam.dbframework.handler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.StudentDao;

public class TransactionExample {
	private static final Logger LOG = Logger.getLogger(TransactionExample.class);

	public void perform() throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		Statement statement = connection.createStatement();
		connection.setAutoCommit(false);
		String sqlRequest2 = "INSERT INTO department VALUES (6,'apply phisics','Grushevskogo');";
		String sqlRequest3 = "INSERT INTO department VALUES (7,'statistics','Dragomanova');";
		String sqlRequest1 = "INSERT INTO department VALUES (8,'mechanics','Universitetska');";
		try {
			statement.executeUpdate(sqlRequest1);
			statement.executeUpdate(sqlRequest2);
			statement.executeUpdate(sqlRequest3);
			LOG.info("useTransactionExample successful");
		} catch (SQLException e) {
			LOG.info("Cannot useTransactionExample");
		}
		connection.commit();
		statement.close();
		connectorToDB.close();
	}

}
