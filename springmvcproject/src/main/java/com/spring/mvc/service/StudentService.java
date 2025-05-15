package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.model.Student;

@Service
public class StudentService {

	public List<Student> listStudents()
	{
		Student student=new Student(1, "Aditya", 99.9);
		Student student1=new Student(2, "Bhushan", 91.9);
		Student student2=new Student(3, "Bhavesh", 85.9);
		Student student3=new Student(4, "Dinesh", 79.9);
		Student student4=new Student(5, "Nikhil", 83.9);
		List<Student> students=new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		return students;
	}
}
