package com.epam.lab.controller;

import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.epam.lab.entity.Department;
import com.epam.lab.entity.Student;
import com.epam.lab.info.Info;
import com.epam.lab.service.DepartmentService;
import com.epam.lab.service.StudentService;

public class MenuController {

	private final static Logger LOGGER = Logger.getLogger(MenuController.class);
	Scanner sc = new Scanner(System.in);
	DepartmentService departmentService = new DepartmentService();
	StudentService studentService = new StudentService();
	Student student;
	Department department;
	Info info = new Info();
	private int choise;

	public void showMenu() {
		boolean isTrue = true;
		while (isTrue) {
			LOGGER.info("Enter number to choose");
			LOGGER.info("1 - operations with students");
			LOGGER.info("2 - operations with departments");
			LOGGER.info("3 - show information about data base");
			choise = sc.nextInt();
			switch (choise) {
			case 1:
				showMenuStudent();
				break;
			case 2:
				showMenuDepartment();
				break;
			case 3:
				info.showAllInfo();
				break;
			default:
				break;
			}
		}
	}

	public void showMenuStudent() {
		LOGGER.info("1 - add student");
		LOGGER.info("2 - show all students");
		LOGGER.info("3 - show one student by id");
		LOGGER.info("4 - delete student by id");
		LOGGER.info("5 - udate student");
		LOGGER.info("Enter number to choose");
		choise = sc.nextInt();
		switch (choise) {
		case 1:
			addStudent();
			break;
		case 2:
			showAllStudent();
			break;
		case 3:
			showOneStudentById();
			break;
		case 4:
			deleteStudent();
			break;
		case 5:
			updateStudent();
			break;
		default:
			break;
		}
	}

	public void addStudent() {
		LOGGER.info("Enter id");
		int id = sc.nextInt();
		LOGGER.info("Enter student first name");
		String firstName = sc.next();
		LOGGER.info("Enter student last name");
		String lasttName = sc.next();
		LOGGER.info("Enter student address name");
		String address = sc.next();
		LOGGER.info("Enter student gender");
		String gender = sc.next();
		LOGGER.info("Enter student department id");
		int depId = sc.nextInt();
		student = new Student(id, firstName, lasttName, address, gender, depId);
		studentService.add(student);
	}

	public void showAllStudent() {
		for (Student st : studentService.getAll()) {
			LOGGER.info(st);
		}
	}

	public void showOneStudentById() {
		LOGGER.info("Enter id student");
		int id = sc.nextInt();
		Student student = studentService.getById(id);
		LOGGER.info(student.toString());
	}

	public void deleteStudent() {
		LOGGER.info("Enter id student");
		int id = sc.nextInt();
		studentService.delete(id);
	}

	public void updateStudent() {
		LOGGER.info("Enter id");
		int id = sc.nextInt();
		LOGGER.info("Enter student first name");
		String firstName = sc.next();
		LOGGER.info("Enter student last name");
		String lasttName = sc.next();
		LOGGER.info("Enter student address name");
		String address = sc.next();
		LOGGER.info("Enter student gender");
		String gender = sc.next();
		LOGGER.info("Enter student department id");
		int depId = sc.nextInt();
		student = new Student(id, firstName, lasttName, address, gender, depId);
		studentService.update(student);
	}

	private void showMenuDepartment() {
		LOGGER.info("Enter your choose");
		LOGGER.info("1 - add department");
		LOGGER.info("2 - show all department");
		LOGGER.info("3 - show one department by id");
		LOGGER.info("4 - delete department by id");
		LOGGER.info("5 - update department");
		choise = sc.nextInt();
		switch (choise) {
		case 1:
			addDepartment();
			break;
		case 2:
			showAllDepartments();
			break;
		case 3:
			showOneDepartmentById();
			break;
		case 4:
			deleteDepartment();
			break;
		case 5:
			updadeDepartment();
			break;
		}
	}

	public void addDepartment() {
		LOGGER.info("Enter department id");
		int id = sc.nextInt();
		LOGGER.info("Enter student department name");
		String depName = sc.next();
		LOGGER.info("Enter student department address");
		String depAddress = sc.next();
		department = new Department(id, depName, depAddress);
		departmentService.add(department);
	}

	public void showAllDepartments() {
		for (Department dep : departmentService.getAll()) {
			LOGGER.info(dep);
		}
	}

	public void showOneDepartmentById() {
		LOGGER.info("Enter id department");
		int id = sc.nextInt();
		LOGGER.info(departmentService.getById(id));
	}

	public void deleteDepartment() {
		LOGGER.info("Enter id department");
		int id = sc.nextInt();
		try {
			departmentService.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
	}

	public void updadeDepartment() {
		LOGGER.info("Enter department id");
		int id = sc.nextInt();
		LOGGER.info("Enter student department name");
		String depName = sc.next();
		LOGGER.info("Enter student department address");
		String depAddress = sc.next();
		department = new Department(id, depName, depAddress);
		departmentService.add(department);
	}
}
