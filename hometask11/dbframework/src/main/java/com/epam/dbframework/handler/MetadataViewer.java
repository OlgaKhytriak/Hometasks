package com.epam.dbframework.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MetadataViewer {

	public void getGeneralInfo() throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		System.out.println("DATA BASE GENERAL INFO:");
		System.out.println("Driver Name: " + databaseMetaData.getDriverName());
		System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
		System.out.println("UserName: " + databaseMetaData.getUserName());
		System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
		System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());

		connectorToDB.close();
	}

	public void getTablesNames() throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		DatabaseMetaData md = connection.getMetaData();
		ResultSet rs = md.getTables("univer", null, "%", null);
		while (rs.next()) {
			System.out.println(rs.getString(3));
		}
		rs.close();
		connectorToDB.close();
	}

	public void getTables() throws Exception {
		System.out.println("ALL TABLES INFO:");
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		DatabaseMetaData metadata = connection.getMetaData();
		ResultSet res = metadata.getTables(null, null, null, new String[] { "TABLE" });

		System.out.println("List of tables: ");
		while (res.next()) {
			System.out.println(
					"   " + res.getString("student") + ", " + res.getString("exams") + ", " + res.getString("subject")
							+ ", " + res.getString("student_book") + ", " + res.getString("department"));
		}
		res.close();
		connectorToDB.close();
	}

	public void getAllTablesInfo() throws Exception {
		getColumnsInfo("student");
		getColumnsInfo("subject");
		getColumnsInfo("department");
		getColumnsInfo("student_book");
		getColumnsInfo("exams");
	}

	public void getColumnsInfo(String tableName) throws Exception {
		StringBuilder builderObj = new StringBuilder();
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		DatabaseMetaData metaObj = connection.getMetaData();
		ResultSet resultSetObj = metaObj.getColumns("univer", null, tableName, "%");
		builderObj.append(tableName + "- table COLUMNS (");
		while (resultSetObj.next()) {
			String columnName = resultSetObj.getString(4);
			builderObj.append(columnName).append(", ");
		}
		builderObj.deleteCharAt(builderObj.lastIndexOf(",")).deleteCharAt(builderObj.lastIndexOf(" ")).append(")")
				.append("\n");
		System.out.println(builderObj.toString());
		resultSetObj.close();
		// statement.close();
		connectorToDB.close();

	}

}
