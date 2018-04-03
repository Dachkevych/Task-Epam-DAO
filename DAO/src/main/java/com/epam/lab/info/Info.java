package com.epam.lab.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.lab.service.Conect;
import com.mysql.jdbc.Statement;

public class Info extends Conect {

	private final static Logger LOGGER = Logger.getLogger(Info.class);
	Connection connect = getConnectio();

	public List<Table> showInfoStudent() {
		List<Table> students = new ArrayList<>();
		String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_KEY, IS_NULLABLE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'test' AND table_name = 'student';";
		try (Statement statement = (Statement) connect.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Table table = new Table();
				table.setName(resultSet.getString("COLUMN_NAME"));
				table.setType(resultSet.getString("DATA_TYPE"));
				table.setKey(resultSet.getString("COLUMN_KEY"));
				table.setCanBeNull(resultSet.getString("IS_NULLABLE"));
				students.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public List<Table> showInfoDepartmnet() {
		List<Table> departments = new ArrayList<>();
		String sql = "SELECT COLUMN_NAME, DATA_TYPE, COLUMN_KEY, IS_NULLABLE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'test' AND table_name = 'department';";
		try (Statement statement = (Statement) connect.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Table table = new Table();
				table.setName(resultSet.getString("COLUMN_NAME"));
				table.setType(resultSet.getString("DATA_TYPE"));
				table.setKey(resultSet.getString("COLUMN_KEY"));
				table.setCanBeNull(resultSet.getString("IS_NULLABLE"));
				departments.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}
	
	public void showAllInfo() {
		printInfoStudentTable();
		printInfoDepartmentTable();
	}

	public void printInfoStudentTable() {
		LOGGER.info(" --------------------STUDENT---------------------");
		for (Table table : showInfoStudent()) {
			LOGGER.info(table);
		}
	}

	public void printInfoDepartmentTable() {
		LOGGER.info(" --------------------DEPARTMENT---------------------");
		for (Table table : showInfoDepartmnet()) {
			LOGGER.info(table);
		}
	}
}
