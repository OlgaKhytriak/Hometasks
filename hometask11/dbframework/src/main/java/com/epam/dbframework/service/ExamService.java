package com.epam.dbframework.service;

import java.util.List;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class ExamService {
	private final Transformer transformer;
	public ExamService(){
		transformer = new Transformer();
	}
	public List<Exam> getExamList() throws Exception {
		return transformer.convertToList(Exam.class);
	}
}
