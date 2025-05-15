package com.springcore.collections;

import java.util.List;

public class Student {

	private int rno;
	private String name;
	private List<String> subjects;
	public Student(int rno, String name, List<String> subjects) {
		super();
		this.rno = rno;
		this.name = name;
		this.subjects = subjects;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRno() {
		return rno;
	}
	public String getName() {
		return name;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", subjects=" + subjects + "]";
	}
	
	
}
