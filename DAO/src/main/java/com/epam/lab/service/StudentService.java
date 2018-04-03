package com.epam.lab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.epam.lab.dao.StudentDAO;
import com.epam.lab.entity.Student;

public class StudentService extends Conect implements StudentDAO {

	Connection connect = getConnectio();

	@Override
	public void add(Student student) {
		String sql = "INSERT INTO student (student_id, student_fname, student_lname, student_address, student_gender, dep_id) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setInt(1, student.getId());
			statement.setString(2, student.getStudentFirstName());
			statement.setString(3, student.getStudentLastName());
			statement.setString(4, student.getStudentAddress());
			statement.setString(5, student.getStudentGender());
			statement.setInt(6, student.getDepId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<>();
		String sql = "SELECT student_id, student_fname, student_lname, student_address, student_gender, dep_id FROM student";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("student_id"));
				student.setStudentFirstName(resultSet.getString("student_fname"));
				student.setStudentLastName(resultSet.getString("student_lname"));
				student.setStudentAddress(resultSet.getString("student_address"));
				student.setStudentGender(resultSet.getString("student_gender"));
				student.setDepId(resultSet.getInt("dep_id"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getById(int id) {
		String sql = "SELECT student_id, student_fname, student_lname, student_address, student_gender, dep_id FROM student WHERE student_id=?";
		Student student = null;
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setInt(1, id);
			student = new Student();
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				student.setId(resultSet.getInt("student_id"));
				student.setStudentFirstName(resultSet.getString("student_fname"));
				student.setStudentLastName(resultSet.getString("student_lname"));
				student.setStudentAddress(resultSet.getString("student_address"));
				student.setStudentGender(resultSet.getString("student_gender"));
				student.setDepId(resultSet.getInt("dep_id"));
			}
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public void update(Student student) {
		String sql = "UPDATE student SET student_fname=?, student_lname=?, student_address=?, student_gender=?, dep_id=? WHERE student_id=?";
		try (PreparedStatement statement = connect.prepareStatement(sql)) {
			statement.setString(1, student.getStudentFirstName());
			statement.setString(2, student.getStudentLastName());
			statement.setString(3, student.getStudentAddress());
			statement.setString(4, student.getStudentGender());
			statement.setInt(5, student.getDepId());
			statement.setInt(6, student.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String depSql = "DELETE FROM student WHERE student_id=?";
		try (PreparedStatement statement = connect.prepareStatement(depSql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
