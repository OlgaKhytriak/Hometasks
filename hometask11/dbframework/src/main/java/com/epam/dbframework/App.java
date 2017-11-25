package com.epam.dbframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;



/**
 * Hello world!
 *
 */
public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
    public static void main( String[] args ) throws SQLException
    {
    	LOG.info( "Hello World!" );
       
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			LOG.info("Driver not found error");
		}  
    	String jdbcUrl = "jdbc:mysql://localhost:3306/sample";
    	String user     = "root";
    	String password = "123qaz";
    	Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
    	
    	Statement stmt = connection.createStatement();
    	String sql = "SELECT * FROM department";
    	ResultSet resultSet = stmt.executeQuery(sql);
    	while(resultSet.next()){
    		String number = resultSet.getString("dept_no");
    		String name = resultSet.getString("dept_name");
    		String location = resultSet.getString("location");
    		LOG.info(number+"  " +name+ "  "+location);
    	}


    }
}
