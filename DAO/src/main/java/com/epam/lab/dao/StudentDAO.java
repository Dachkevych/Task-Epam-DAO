package com.epam.lab.dao;

import java.util.List;
import com.epam.lab.entity.Student;

public interface StudentDAO {
	
	//add new student
	void add(Student student);

	//get all student from data base
	List<Student> getAll();
	
	//get one student by id
	Student getById(int id);
	
	//update student
	void update(Student student);
	
	//delete student
	void delete(int id);
}
