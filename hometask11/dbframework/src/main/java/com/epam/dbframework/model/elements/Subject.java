package com.epam.dbframework.model.elements;

import com.epam.dbframework.model.anotations.FieldAnn;

public class Subject {
	@FieldAnn("id")
	private Integer id;
	@FieldAnn("name")
	private String name;
	@FieldAnn("description")
	private String description;

	public Subject() {
	}

	public Subject(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public String toString() {
		return String.format("Subject:: id= %s | name= %s | description = %s |", id, name, description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
