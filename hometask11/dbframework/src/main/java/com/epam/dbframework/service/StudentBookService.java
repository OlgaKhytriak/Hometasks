package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.Exam;
import com.epam.dbframework.model.elements.StudentBook;

public class StudentBookService extends BasicService {
	private static final Logger LOG = Logger.getLogger(StudentBookService.class);

	
	public void deleteStudentBookByID(Integer id) throws Exception {
		transformer.deleteRowsByID(StudentBook.class, id);
	}

	public void createTableInDB(String tableName) throws Exception {
		transformer.createTableForInstance(StudentBook.class, tableName);
	}

	public List<StudentBook> getStudentBookList() throws Exception {
		return transformer.getAllDataList(StudentBook.class);
	}

	public List<StudentBook> getStudentBookByID(Integer id) throws Exception {
		List<StudentBook> rezList = transformer.getDataListByID(StudentBook.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No student book with id = %s", id));
		}
		return rezList;
	}
}
