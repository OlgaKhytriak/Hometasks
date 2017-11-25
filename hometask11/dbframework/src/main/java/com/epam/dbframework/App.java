package com.epam.dbframework;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.*;
import com.epam.dbframework.service.*;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		studentProcessor();
		//studentBookProcessor();
		//departmentProcessor();
		//subjectProcessor();
		//examProcessor();
	}

	public static void studentBookProcessor() throws Exception {
		StudentBookService studentBookService = new StudentBookService();
		List<StudentBook> studentsBookList = studentBookService.getStudentBookList();
		for (StudentBook st : studentsBookList) {
			System.out.println(st.toString());
		}
	}

	public static void subjectProcessor() throws Exception {
		SubjectService subjectService = new SubjectService();
		List<Subject> subjectList = subjectService.getSubjectList();
		for (Subject st : subjectList) {
			System.out.println(st.toString());
		}
	}

	public static void departmentProcessor() throws Exception {
		DepartmentService departmentService = new DepartmentService();
		List<Department> departmentList = departmentService.getDepatrmentList();
		for (Department st : departmentList) {
			System.out.println(st.toString());
		}
	}

	public static void examProcessor() throws Exception {
		ExamService examService = new ExamService();
		List<Exam> examList = examService.getExamList();
		for (Exam st : examList) {
			System.out.println(st.toString());
		}

	}

	public static void studentProcessor() throws Exception {
		StudentService studentService = new StudentService();
		List<Student> studentsList = studentService.getStudentsList();
		for (Student st : studentsList) {
			System.out.println(st.toString());
		}
		System.out.println("Student by ID");
		//Student student = studentService.getStudentByID(new Integer(1));
		//System.out.println(student.toString());
	}
}
