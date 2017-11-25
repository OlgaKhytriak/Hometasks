package com.epam.dbframework.service;

import java.util.List;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class SubjectService {
	private final Transformer transformer;
	public SubjectService(){
		transformer = new Transformer();
	}
	public List<Subject> getSubjectList() throws Exception {
		return transformer.convertToList(Subject.class);
	}
}
