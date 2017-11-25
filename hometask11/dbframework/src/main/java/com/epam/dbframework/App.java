package com.epam.dbframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.handler.ConnectorToDB;
import com.epam.dbframework.model.elements.*;

public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
    public static void main( String[] args ) throws SQLException, InstantiationException, IllegalAccessException
    {
    	StudentDAO studentDAO=new StudentDAO();    	
		List<Student> studentsList=studentDAO.getAllStudents();
		for (Student st: studentsList) {
			System.out.println(st.toString());
		}
    }
}
