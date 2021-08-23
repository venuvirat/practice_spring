package com.example.student.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.student.controller.Student;

public interface StudentDao {
	public Student getStudentById(int id);

	public void saveStudent(Student student);

	public List<Student> getAllStudents();

}
