package com.epam.dbframework.model.elements;

import java.util.Date;

import com.epam.dbframework.model.anotations.FieldAnn;
import com.epam.dbframework.model.anotations.Entity;

@Entity("student_book")
public class StudentBook extends ModelElement {
	@FieldAnn(value = "id", type = "INT(11)")
	private Integer id;
	@FieldAnn(value = "entry_date", type = "DATE")
	private Date entryDate;
	@FieldAnn("group")
	private String group;
	@FieldAnn(value = "course", type = "INT(11)")
	private Integer course;

	public StudentBook() {
	}

	public String toValuesString() {
		return String.format("(%s,\'%s\',\'%s\',%s)", id, entryDate, group, course);
	}

	public StudentBook(int id, Date entryDate, String group, Integer course) {
		this.id = id;
		this.entryDate = entryDate;
		this.group = group;
		this.course = course;
	}

	public String toString() {
		return String.format("student_book:: id= %s | entryDate= %s | group = %s | course = %s |", id, entryDate, group,
				course);
	}

	// ------------------------getters and setters------------------------------
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}
}
