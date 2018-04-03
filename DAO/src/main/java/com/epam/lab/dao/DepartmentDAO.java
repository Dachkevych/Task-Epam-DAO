package com.epam.lab.dao;

import java.sql.SQLException;
import java.util.List;
import com.epam.lab.entity.Department;

public interface DepartmentDAO {

	// add new department
	void add(Department department);

	// get all department from data bace
	List<Department> getAll();

	// get one department by id
	Department getById(int id);

	// update department
	void update(Department department);

	// delete department
	void delete(int id) throws SQLException;
}
