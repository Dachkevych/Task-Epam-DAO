package com.epam.lab.info;

public class Table {

	private String name;
	private String type;
	private String canBeNull;
	private String key;

	public Table() {
	}

	public Table(String name, String type, String canBeNull, String key) {
		this.name = name;
		this.type = type;
		this.canBeNull = canBeNull;
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCanBeNull() {
		return canBeNull;
	}

	public void setCanBeNull(String canBeNull) {
		this.canBeNull = canBeNull;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "COLUMN NAME - " + name + " | TYPE - " + type + " | CAN BE NULL - " + canBeNull + " | KEY - " + key;
	}
}
