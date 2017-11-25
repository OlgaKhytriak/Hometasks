package com.epam.dbframework.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.epam.dbframework.handler.ConnectorToDB;
import com.epam.dbframework.model.anotations.FieldAnn;
import com.epam.dbframework.model.anotations.TableAnn;

public class TableDAO {
	private static final Logger LOG = Logger.getLogger(TableDAO.class);
	
	public <T> List<T> getTable(Class<T> clazz) throws Exception{
		List<T> listAllInstances = new ArrayList<T>();
		ConnectorToDB connectorToDB = new ConnectorToDB();
		Connection connection = connectorToDB.connect();
		TableAnn classAnnotation = (TableAnn) clazz.getAnnotation(TableAnn.class);
		String anotName=classAnnotation.value();
		String sql = "SELECT * FROM "+anotName;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			listAllInstances.add((T) convertToInstance(clazz,resultSet));
		}
		statement.close();
		connectorToDB.close();
		return listAllInstances;
	}

	private <T> T convertToInstance(Class<T> clazz, ResultSet resultSet) 
			throws SQLException, InstantiationException, IllegalAccessException{
		T currentInstance = (T) clazz.newInstance() ;
		Field[] fields = currentInstance.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isAnnotationPresent(FieldAnn.class)) {
				FieldAnn fieldAnnotations = fields[i].getDeclaredAnnotation(FieldAnn.class);
				String anotName=fieldAnnotations.value();
				setField(currentInstance, fields[i],resultSet.getObject(anotName));
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
	private <T> void setField(Object obj, String fieldName, T value) {
		try {
			Class<?> clazz = obj.getClass();
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
			System.err.println("In FieldsInvoker method  exception. Set is failed");
		}
		
	}
}

/*public List<Student> getAllStudents() throws SQLException, InstantiationException, IllegalAccessException {
List<Student> listAllStudents = new ArrayList<Student>();
ConnectorToDB connectorToDB = new ConnectorToDB();
Connection connection = connectorToDB.connect();
String sql = "SELECT * FROM student";
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery(sql);
while (resultSet.next()) {
	Student currentStudent = convertToInstance(Student.class,resultSet);
		listAllStudents.add(currentStudent);
}
statement.close();
connectorToDB.close();
return listAllStudents;
}
*/

/*private Student createStudent(ResultSet resultSet){
Student currentStudent = new Student();
try {
	currentStudent.setId(resultSet.getInt("id"));
	currentStudent.setFirstName(resultSet.getString("first_name"));
	currentStudent.setLastName(resultSet.getString("last_name"));
	currentStudent.setBirthday(resultSet.getDate("birthday"));
	currentStudent.setAdress(resultSet.getString("adress"));
	currentStudent.setPhone(resultSet.getString("phone"));
	currentStudent.setStudentBookId(resultSet.getInt("student_book_id"));
	currentStudent.setDepartmentId(resultSet.getInt("department_id"));
} catch (Exception e) {
	LOG.info("Error in createStudent method");
}		
return currentStudent;
}
*/


