package com.epam.finalproject.jdbc.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.finalproject.jdbc.anotation.*;

public class Transformer {
	private static final Logger LOG = Logger.getLogger(Transformer.class);

	public <T> int deleteRowsByID(Class<T> clazz,Integer id) throws Exception{
		Entity classAnnotation = (Entity) clazz.getAnnotation(Entity.class);
		String anotName = classAnnotation.value();
		String sqlRequest =String.format("DELETE FROM  %s WHERE id=%s",anotName,id);			
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		Statement statement = connection.createStatement();
		statement.executeUpdate(sqlRequest);	
		statement.close();
		connectorToDB.close();
		return 1;
	}
	public <T> void createTableForInstance(Class<T> clazz,String tableName) throws InstantiationException, IllegalAccessException, Exception{
		 String sqlRequest=makeSqlRequestForTableCraetion(clazz,tableName);
		 System.out.println(sqlRequest);
		 ConnectorToDB connectorToDB = new ConnectorToDB();
			Connection connection = connectorToDB.connect();
			Statement statement = connection.createStatement();
			try {
				statement.executeUpdate(sqlRequest);
				LOG.info("Table" + tableName+"was created");
			} catch (SQLException e) {
				LOG.info("Cannot create table"+ tableName);
			}			
			statement.close();
			connectorToDB.close();	 
	}
	
	private <T> String makeSqlRequestForTableCraetion(Class<T> clazz,String tableName) throws InstantiationException, IllegalAccessException {

		Entity classAnnotation = (Entity) clazz.getAnnotation(Entity.class);
		String anotClassName = classAnnotation.value();		
		String primaryKeyName="";
		String sql = "CREATE TABLE " + tableName+"( ";             
		T currentInstance = (T) clazz.newInstance();
		Field[] fields = currentInstance.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(EntityField.class)) {
				EntityField fieldAnnotations = fields[i].getDeclaredAnnotation(EntityField.class);
				String anotFieldName = fieldAnnotations.value();
				String anotFieldType = fieldAnnotations.type();
				if (0==i) {
					 primaryKeyName=anotFieldName;
					sql=sql+" "+anotFieldName+ " "+anotFieldType+" NOT NULL,";
				}else {
				sql=sql+" "+anotFieldName+ " "+anotFieldType+", ";
				}			
			}
		}
		sql=sql+"PRIMARY KEY ("+primaryKeyName+"));" ;
		return sql;	
	}
	
	public <T> List<T> getDataListByID(Class<T> clazz,Integer id) throws Exception{
		Entity classAnnotation = (Entity) clazz.getAnnotation(Entity.class);
		String anotName = classAnnotation.value();
		String sqlRequest =String.format("SELECT * FROM  %s WHERE id=%s",anotName,id);		
		return convertToList(clazz, sqlRequest);
	}
	public <T> List<T> getAllDataList(Class<T> clazz) throws Exception{
		Entity classAnnotation = (Entity) clazz.getAnnotation(Entity.class);
		String anotName = classAnnotation.value();
		String sqlRequest =String.format("SELECT * FROM  %s",anotName);		
		return convertToList(clazz, sqlRequest);
	}
	
	private <T> List<T> convertToList(Class<T> clazz, String sqlRequest) throws Exception {
		List<T> instancesList = new ArrayList<T>();
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sqlRequest);
		//if (resultSet.next()){
		while (resultSet.next()) {
			instancesList.add((T) convertToInstance(clazz, resultSet));
		}
		//}
		//else {
		//	LOG.info("No results in result set");
		//}
		statement.close();
		connectorToDB.close();
		return instancesList;
	}

	private <T> T convertToInstance(Class<T> clazz, ResultSet resultSet)
			throws SQLException, InstantiationException, IllegalAccessException {
		T currentInstance = (T) clazz.newInstance();
		Field[] fields = currentInstance.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(EntityField.class)) {
				EntityField fieldAnnotations = fields[i].getDeclaredAnnotation(EntityField.class);
				String anotName = fieldAnnotations.value();
				setField(currentInstance, fields[i], resultSet.getObject(anotName));
			}
		}
		return currentInstance;
	}	
	private <T> void setField(Object obj, Field field, T value) {
		try {
			Class<?> clazz = obj.getClass();
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			System.err.println("In FieldsInvoker method  exception. Set is failed");
		}

	}
}

