package com.epam.dbframework;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.*;
import com.epam.dbframework.service.*;

public class App {
	private static final Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		//studentProcessor();
		studentBookProcessor();
		//departmentProcessor();
		//subjectProcessor();
		//examProcessor();
	}
	
	public static void studentProcessor() throws Exception {
		StudentService studentService = new StudentService();
		List<Student> studentsList = studentService.getStudentsList();
		printList(studentsList);
		
		System.out.println("Student by ID");
		List<Student> studentsListID = studentService.getStudentByID(7);
		printList(studentsListID);
	}

	public static void studentBookProcessor() throws Exception {
		StudentBookService studentBookService = new StudentBookService();
		List<StudentBook> studentsBookList = studentBookService.getStudentBookList();
		printList(studentsBookList);
		System.out.println("studentBook by ID");
		List<StudentBook> bookListID = studentBookService.getStudentBookByID(20326);
		printList(bookListID);
		
		
		
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
	public static <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element.toString());
		}
	}

	
}
