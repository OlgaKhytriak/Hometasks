package com.epam.dbframework.model.elements;

import java.util.Date;

import com.epam.dbframework.model.anotations.FieldAnn;

public class Department {
	@FieldAnn("id")
	private Integer id;
	@FieldAnn("name")
	private String name;
	@FieldAnn("location")
	private String location;

	public Department() {
	}

	public Department(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String toString() {
		return String.format("Department:: id= %s | name= %s | location = %s |", id, name, location);
	}

	// ------------------------getters and setters------------------------------
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
