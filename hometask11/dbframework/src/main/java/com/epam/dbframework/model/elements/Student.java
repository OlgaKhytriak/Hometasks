package com.epam.dbframework.model.elements;

import java.util.Date;

import com.epam.dbframework.model.anotations.FieldAnn;

public class Student {
	@FieldAnn("id")
	private Integer id;
	@FieldAnn("first_name")
	private String firstName;
	@FieldAnn("last_name")
	private String lastName;
	@FieldAnn("birthday")
	private Date birthday;
	@FieldAnn("adress")
	private String adress;
	@FieldAnn("phone")
	private String phone;
	@FieldAnn("student_book_id")
	private Integer studentBookId;
	@FieldAnn("department_id")
	private Integer departmentId;
	
	public Student() {
	}
	
	public Student(int id, String firstName, String lastName, Date birthday,String adress, String phone,Integer studentBookId,Integer departmentId) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthday=birthday;
		this.adress=adress;
		this.phone=phone;
		this.studentBookId=studentBookId;
		this.departmentId=departmentId;
	}

	 public String toString() {
		 return String.format("Student:: id= %s | first_name= %s | last_name= %s | birthday= %s | adress= %s | phone=%s | student_book_id= %s | department_id= %s | ", id, firstName,lastName,birthday,adress,phone,studentBookId,departmentId);
		     }
//------------------------getters and setters------------------------------	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getStudentBookId() {
		return studentBookId;
	}
	public void setStudentBookId(Integer studentBookId) {
		this.studentBookId = studentBookId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
//----------------------------------------------------------------	
}
