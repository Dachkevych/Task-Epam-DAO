package com.epam.lab.entity;

public class Department {

	private int depId;
	private String depName;
	private String depAddress;

	public Department() {
	}

	public Department(int depId, String depName, String depAddress) {
		this.depId = depId;
		this.depName = depName;
		this.depAddress = depAddress;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepAddress() {
		return depAddress;
	}

	public void setDepAddress(String depAddress) {
		this.depAddress = depAddress;
	}

	@Override
	public String toString() {
		return "Department - [ID = " + depId + "] : " + "[NAME = " + depName + "] : " + "[ADDRESS2 = " + depAddress
				+ "].";
	}
}
