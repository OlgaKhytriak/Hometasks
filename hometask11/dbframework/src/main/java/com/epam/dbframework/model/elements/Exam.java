package com.epam.dbframework.model.elements;

import java.util.Date;

import com.epam.dbframework.model.anotations.FieldAnn;
import com.epam.dbframework.model.anotations.Entity;
@Entity("exams")
public class Exam extends ModelElement{
	@FieldAnn(value="id",type="INT(11)")
	private Integer id;
	@FieldAnn(value="student_id",type="INT(11)")
	private Integer studentID;
	@FieldAnn(value="subject_id",type="INT(11)")
	private Integer subjectID;
	@FieldAnn(value="date",type="DATE")
	private Date date;
	@FieldAnn(value="mark",type="INT(11)")
	private Integer mark;

	public Exam() {
	}

	public Exam(int id, Integer studentID, Integer subjectID, Date date, Integer mark) {
		this.id = id;
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.date = date;
		this.mark = mark;
	}
	@Override
	public String toValuesString() {
		return String.format("(%s,%s,%s,\'%s\',%s)", id,studentID,subjectID, date,mark );
	}
	public String toString() {
		return String.format("Exam:: id= %s | studentID= %s | subjectID = %s |date = %s |mark = %s |", id, studentID, subjectID,date,mark);
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
