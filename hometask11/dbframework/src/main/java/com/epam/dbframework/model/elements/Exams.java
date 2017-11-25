package com.epam.dbframework.model.elements;

import java.util.Date;

import com.epam.dbframework.model.anotations.FieldAnn;

public class Exams {
	@FieldAnn("id")
	private Integer id;
	@FieldAnn("student_id")
	private Integer studentID;
	@FieldAnn("subject_id")
	private Integer subjectID;
	@FieldAnn("date")
	private Date date;
	@FieldAnn("mark")
	private Integer mark;

	public Exams() {
	}

	public Exams(int id, Integer studentID, Integer subjectID, Date date, Integer mark) {
		this.id = id;
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.date = date;
		this.mark = mark;
	}
	
	//------------------------getters and setters------------------------------	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	
}
