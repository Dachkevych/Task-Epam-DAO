package com.epam.lab.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.epam.lab.dao.DepartmentDAO;
import com.epam.lab.entity.Department;
import com.mysql.jdbc.Statement;

public class DepartmentService extends Conect implements DepartmentDAO {

	Connection connect = getConnectio();

	@Override
	public void add(Department department) {
		String sql = "INSERT INTO department (dep_id, dep_name, dep_address) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setInt(1, department.getDepId());
			statement.setString(2, department.getDepName());
			statement.setString(3, department.getDepAddress());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Department> getAll() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT dep_id, dep_name, dep_address FROM department";
		try (Statement statement = (Statement) connect.createStatement()) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Department department = new Department();
				department.setDepId(resultSet.getInt("dep_id"));
				department.setDepName(resultSet.getString("dep_name"));
				department.setDepAddress(resultSet.getString("dep_address"));
				departments.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public Department getById(int id) {
		Department department = new Department();
		String sql = "SELECT * FROM department WHERE dep_id=?";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				department.setDepId(resultSet.getInt("dep_id"));
				department.setDepName(resultSet.getString("dep_name"));
				department.setDepAddress(resultSet.getString("dep_address"));
			}
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public void update(Department department) {
		String sql = "UPDATE department SET dep_name=?, dep_address=? WHERE dep_id=?";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setString(1, department.getDepName());
			statement.setString(2, department.getDepAddress());
			statement.setInt(3, department.getDepId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * There are two query in one transaction.
	 */
	@SuppressWarnings("resource")
	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement statement = null;
		String deleteDep = "DELETE FROM department WHERE dep_id=?";
		String changeStudentDepId = "UPDATE student SET dep_id=99 WHERE dep_id=?";
		try {
			connect.setAutoCommit(false);
			statement = connect.prepareStatement(changeStudentDepId);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement = connect.prepareStatement(deleteDep);
			statement.setInt(1, id);
			statement.executeUpdate();
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}
}
