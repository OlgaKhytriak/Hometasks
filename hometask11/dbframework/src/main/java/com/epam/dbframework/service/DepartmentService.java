package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class DepartmentService {
	private static final Logger LOG = Logger.getLogger(DepartmentService.class);
	private final Transformer transformer;
	public DepartmentService(){
		transformer = new Transformer();
	}
	public List<Department> getDepatrmentList() throws Exception {
		return transformer.getAllDataList(Department.class);
	}
	
	public List<Department> getDepartmentByID(Integer id) throws Exception
	{
		List<Department> rezList=transformer.getDataListByID(Department.class, id);
		if (rezList.isEmpty()) {
			LOG.info(String.format("No department with id = %s", id));
		}
		return rezList;
	}
}
