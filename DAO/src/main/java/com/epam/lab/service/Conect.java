package com.epam.lab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {

	private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/test";
	private final static String DB_USERNAME = "root";
	private final static String DB_PASSWORD = "root";

	public Connection getConnectio() {
		Connection connection = null;
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		return connection;
	}
}
