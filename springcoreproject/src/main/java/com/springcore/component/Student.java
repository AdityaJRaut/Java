package com.springcore.component;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {

	private int rno;
	private String name;
	@Autowired
	private Subject subject;
	public Student(int rno, String name, Subject subject) {
		super();
		this.rno = rno;
		this.name = name;
		this.subject = subject;
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
	public Subject getSubject() {
		return subject;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", subject=" + subject + "]";
	}
	
	
	
	
}
