package com.epam.dbframework.service;

import java.util.List;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class DepartmentService {
	private final Transformer transformer;
	public DepartmentService(){
		transformer = new Transformer();
	}
	public List<Department> getDepatrmentList() throws Exception {
		return transformer.getAllDataList(Department.class);
	}
}
