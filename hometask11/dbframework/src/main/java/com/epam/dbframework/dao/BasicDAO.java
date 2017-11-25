package com.epam.dbframework.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.dbframework.handler.ConnectorToDB;
import com.epam.dbframework.model.anotations.Entity;

public class BasicDAO {
	private final Transformer transformer;
	public BasicDAO(){
		transformer = new Transformer();
	}
	public <T> T getByID(Class<T> clazz,Integer id) throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		Entity classAnnotation = (Entity) clazz.getAnnotation(Entity.class);
		String anotName=classAnnotation.value();
		String sql = "SELECT * FROM " + anotName+" where id=1";
		System.out.println(sql);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println(resultSet.getInt("id"));
		T currentInstance = clazz.newInstance();
		currentInstance=transformer.convertToInstance(clazz,resultSet);
		statement.close();
		connectorToDB.close();
		return currentInstance;
		
	}
}
