package com.epam.dbframework.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.dbframework.dao.ExamDao;
import com.epam.dbframework.dao.StudentDao;
import com.epam.dbframework.dao.Transformer;
import com.epam.dbframework.model.elements.Exam;
import com.epam.dbframework.model.elements.Student;

public class ExamService extends BasicService{
	private static final Logger LOG = Logger.getLogger(ExamService.class);
	private final ExamDao examDao;
	public ExamService() {
		examDao = new ExamDao();
	}
	public void deleteExamByID(Integer id) throws Exception {
		transformer.deleteRowsByID(Exam.class, id);
	}
	public void createTableInDB(String tableName) throws Exception {
		transformer.createTableForInstance(Exam.class, tableName);
		examDao.setExamForeignKeys(tableName);
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
