package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.Exam;

public class ExamService {
	private static final Logger LOG = Logger.getLogger(ExamService.class);
	private final Transformer transformer;

	public ExamService() {
		transformer = new Transformer();
	}

	public List<Exam> getExamList() throws Exception {
		return transformer.getAllDataList(Exam.class);

	}

	public List<Exam> getExamByID(Integer id) throws Exception {
		List<Exam> rezList = transformer.getDataListByID(Exam.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No exam with id = %s", id));
		}
		return rezList;
	}
}
