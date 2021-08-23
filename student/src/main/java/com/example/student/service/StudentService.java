package com.example.student.service;

import java.util.List;


import com.example.student.controller.Student;
import com.example.student.exceptions.InvalidCredentialsException;
import com.example.student.exceptions.InvalidCredentialsException;

public interface StudentService {
	public Student getStudentById(int id);

	public void saveStudent(Student student) throws InvalidCredentialsException;

	public List<Student> getAllStudents();
	
	public void deleteStudentById(int id);
}
