package com.epam.dbframework.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.epam.dbframework.handler.ConnectorToDB;

public class StudentDao extends BasicDao {
	private static final Logger LOG = Logger.getLogger(StudentDao.class);

	public void setStudentForeignKeys(String maintableName) throws Exception {
		String sqlRequest = "ALTER TABLE " + maintableName
				+ " ADD FOREIGN KEY (student_book_id) REFERENCES student_book (id),"
				+ " ADD FOREIGN KEY (department_id) REFERENCES department (id)";
		setForeignKeys(maintableName, sqlRequest);
	}
	
	public void transferStudentBetweenDepartments(Integer sourceDepartmentID, Integer destinationDepartmentID) throws Exception {
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		String sqlRequest = String.format("UPDATE student set department_id = %s WHERE id = %s;", destinationDepartmentID, sourceDepartmentID);
		System.out.println(sqlRequest);
		Statement statement = connection.createStatement();
		try {
			statement.executeUpdate(sqlRequest);
			LOG.info("Field department in table student  was updated");
		} catch (SQLException e) {
			LOG.info("Cannot updated table student");
		}
		statement.close();
		connectorToDB.close();
		}
	}
