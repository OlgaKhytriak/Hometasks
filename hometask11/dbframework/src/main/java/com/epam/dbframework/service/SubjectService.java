package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.BasicDao;
import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.ModelElement;
import com.epam.dbframework.model.elements.Student;
import com.epam.dbframework.model.elements.StudentBook;
import com.epam.dbframework.model.elements.Subject;

public class SubjectService extends BasicService{
	private static final Logger LOG = Logger.getLogger(SubjectService.class);
	
	public void deleteSubjectByID(Integer id) throws Exception {
		transformer.deleteRowsByID(Subject.class, id);
	}

	
	public void createTableInDB(String tableName) throws Exception {
		transformer.createTableForInstance(Subject.class, tableName);
	}

	public List<Subject> getSubjectList() throws Exception {
		return transformer.getAllDataList(Subject.class);
	}

	public List<Subject> getSubjectByID(Integer id) throws Exception {
		List<Subject> rezList = transformer.getDataListByID(Subject.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No subject with id = %s", id));
		}
		return rezList;
	}
}
