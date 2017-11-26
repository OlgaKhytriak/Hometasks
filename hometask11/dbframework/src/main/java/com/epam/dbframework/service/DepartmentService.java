package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.*;
import com.epam.dbframework.model.elements.*;

public class DepartmentService extends BasicService{
	private static final Logger LOG = Logger.getLogger(DepartmentService.class);
	
	
	public void deleteDepartmentTransferStudent(Integer sourceDepartmentID, Integer destinationDepartmentID) throws Exception {
		StudentDao studentDao=new StudentDao();
		studentDao.transferStudentBetweenDepartments(sourceDepartmentID, destinationDepartmentID);
		deleteDepartmentByID(sourceDepartmentID);
	}
	
	
	public void deleteDepartmentByID(Integer id) throws Exception {
		transformer.deleteRowsByID(Department.class, id);
	}
	public void createTableInDB(String tableName) throws Exception {
		transformer.createTableForInstance(Department.class, tableName);
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
