package com.epam.lab.entity;

public class Student {

	private int id;
	private String studentFirstName;
	private String studentLastName;
	private String studentAddress;
	private String studentGender;
	private int depId;

	public Student() {
	}

	public Student(int id, String studentFirstName, String studentLastName, String studentAddress, String studentGender,
			int depId) {
		this.id = id;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAddress = studentAddress;
		this.studentGender = studentGender;
		this.depId = depId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Student - [ID = " + id + "] : " + "[FIRST NAME = " + studentFirstName + "] : " + "[LAST NAME = "
				+ studentLastName + "] : " + "[GENDER = " + studentGender + "] : " + "[ADDRESS = " + studentAddress
				+ "]" + "[DEP.ID = " + depId + "].";
	}
}
