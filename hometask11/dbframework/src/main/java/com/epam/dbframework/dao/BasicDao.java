package com.epam.dbframework.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.dbframework.handler.ConnectorToDB;
import com.epam.dbframework.model.anotations.FieldAnn;
import com.epam.dbframework.model.elements.ModelElement;

public class BasicDao {
	private static final Logger LOG = Logger.getLogger(BasicDao.class);

	private final Transformer transformer;

	public BasicDao() {
		transformer = new Transformer();
	}

	public void insertRecord(ModelElement modelElement, String tableName) throws Exception {
	String value=modelElement.toValuesString();
    ConnectorToDB connectorToDB = new ConnectorToDB();
	Connection connection = connectorToDB.connect();
	String sqlRequest = String.format("INSERT INTO %s VALUES %s;", tableName, value);
	System.out.println(sqlRequest);
	Statement statement = connection.createStatement();
	try {
		statement.executeUpdate(sqlRequest);
		LOG.info("Table " + tableName + " was updated");
	} catch (SQLException e) {
		LOG.info("Cannot updated table " + tableName);
	}
	statement.close();
	connectorToDB.close();
	}
	
	public void dropTable(String tableName) throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		String sqlRequest = String.format("DROP TABLE %s.%s", connectorToDB.DB_NAME, tableName);
		Statement statement = connection.createStatement();
		try {
			statement.executeUpdate(sqlRequest);
			LOG.info("Table " + tableName + " was deleted");
		} catch (SQLException e) {
			LOG.info("Cannot delete table " + tableName);
		}
		statement.close();
		connectorToDB.close();
	}

	public void setForeignKeys(String maintableName, String sqlRequest) throws Exception {
		System.out.println(sqlRequest);
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		Statement statement = connection.createStatement();
		try {
			statement.executeUpdate(sqlRequest);
			LOG.info("Foreign keys were added in " + maintableName);
		} catch (SQLException e) {
			LOG.info("Cannot create Foreign keys in " + maintableName);
		}
		statement.close();
		connectorToDB.close();

	}

}
