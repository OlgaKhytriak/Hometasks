package com.epam.dbframework.dao;

import org.apache.log4j.Logger;

public class ExamDao extends BasicDao {
	private static final Logger LOG = Logger.getLogger(ExamDao.class);

	public void setExamForeignKeys(String maintableName) throws Exception {
		String sqlRequest = "ALTER TABLE " + maintableName + " ADD FOREIGN KEY (student_id) REFERENCES student (id),"
				+ " ADD FOREIGN KEY (subject_id) REFERENCES subject (id)";
		setForeignKeys(maintableName, sqlRequest);
	}
}
