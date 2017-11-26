package com.epam.dbframework.service;

import java.util.List;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class StudentBookService {
	private final Transformer transformer;
	public StudentBookService(){
		transformer = new Transformer();
	}
	public List<StudentBook> getStudentBookList() throws Exception {
		return transformer.getAllDataList(StudentBook.class);
	}
}
