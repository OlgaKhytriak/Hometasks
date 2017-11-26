package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.Subject;

public class SubjectService {
	private static final Logger LOG = Logger.getLogger(SubjectService.class);
	private final Transformer transformer;

	public SubjectService() {
		transformer = new Transformer();
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
