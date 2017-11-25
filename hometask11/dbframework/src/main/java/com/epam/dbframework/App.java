package com.epam.dbframework;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.TableDAO;
import com.epam.dbframework.model.elements.Student;

public class App 
{
	 private static final Logger LOG = Logger.getLogger(App.class);
    public static void main( String[] args ) throws Exception
    {
    	TableDAO tableDAO=new TableDAO();    	
		List<Student> studentsList=tableDAO.getTable(Student.class);
		for (Student st: studentsList) {
			System.out.println(st.toString());
		}
    }
}
