package com.epam.dbframework.service;

import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.App;
import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.Student;

public class StudentService {
	private static final Logger LOG = Logger.getLogger(StudentService.class);
	private final Transformer transformer;
	private final BasicDAO basicDAO;
	public StudentService(){
		transformer = new Transformer();
		basicDAO = new BasicDAO();
	}
	public List<Student> getStudentsList() throws Exception {
		return transformer.getAllDataList(Student.class);
	}
	
	public List<Student> getStudentByID(Integer id) throws Exception
	{
		List<Student> rezList=transformer.getDataListByID(Student.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No students with id = %s", id));
		}
		return rezList;
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
