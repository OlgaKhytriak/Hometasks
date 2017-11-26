package com.epam.dbframework.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadataViewer {

	
	public void getGeneralInfo() throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		DatabaseMetaData databaseMetaData=connection.getMetaData();  
		  
		System.out.println("Driver Name: "+databaseMetaData.getDriverName());  
		System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());  
		System.out.println("UserName: "+databaseMetaData.getUserName());  
		System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());  
		System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());  
		  
		connectorToDB.close();
	}
	public void getTablesInfo() throws Exception {	
	String table[]={"TABLE"}; 
	ConnectorToDB connectorToDB = new ConnectorToDB();
	Connection connection = connectorToDB.connect();
	DatabaseMetaData databaseMetaData=connection.getMetaData();  
	ResultSet resultSet=databaseMetaData.getTables(null, null, null, table);  
	  
	while(resultSet.next()){  
	System.out.println(resultSet.getString(3));  
	} 
	connectorToDB.close();
	}
	
}
