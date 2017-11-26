package com.epam.dbframework.service;

import java.sql.ResultSet;
import java.util.List;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.Student;

public class StudentService {
	private final Transformer transformer;
	private final BasicDAO basicDAO;
	public StudentService(){
		transformer = new Transformer();
		basicDAO = new BasicDAO();
	}
	public List<Student> getStudentsList() throws Exception {
		return transformer.getAllDataList(Student.class);
	}
	
	public Student getStudentByID(Integer id) throws Exception
	{
		return null;//transformer.getByID(Student.class, id);
	}
	
	
	/* private Student createStudent(ResultSet resultSet){ Student currentStudent =
	 new Student(); try { currentStudent.setId(resultSet.getInt("id"));
	 currentStudent.setFirstName(resultSet.getString("first_name"));
	 currentStudent.setLastName(resultSet.getString("last_name"));
	 currentStudent.setBirthday(resultSet.getDate("birthday"));
	 currentStudent.setAdress(resultSet.getString("adress"));
	 currentStudent.setPhone(resultSet.getString("phone"));
	 currentStudent.setStudentBookId(resultSet.getInt("student_book_id"));
	 currentStudent.setDepartmentId(resultSet.getInt("department_id")); } catch
	 (Exception e) { LOG.info("Error in createStudent method"); } return
	 currentStudent; }
	 */
}
