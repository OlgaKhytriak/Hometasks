package com.epam.dbframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.apache.log4j.Logger;

import com.epam.dbframework.handler.ConnectorToDB;
import com.epam.dbframework.model.elements.Student;

public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
    public static void main( String[] args ) throws SQLException
    {
    	LOG.info( "Hello World!" );
    	Student st=new Student(12, "Olga", "Petrova", new Date(1), "Lviv", "phone", 12, 14);
    		System.out.println(st.toString());	
    	Connection connection=new ConnectorToDB().connect();
    	Statement statement = connection.createStatement();
    	String sql = "SELECT * FROM department";
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()){
    		String number = resultSet.getString("dept_no");
    		String name = resultSet.getString("dept_name");
    		String location = resultSet.getString("location");
    		LOG.info(number+"  " +name+ "  "+location);
    	}
    	resultSet.close();
    	statement.close();
    	connection.close();

    }
}
