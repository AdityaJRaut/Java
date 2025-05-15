package com.springcore.autowire.type;

public class Student {

	private int rno;
	private String name;
	private double marks;
	private Subject subject;
	
	public Student() {}
	public Student(int rno, String name, double marks, Subject subject) {
		super();
		this.rno = rno;
		this.name = name;
		this.marks = marks;
		this.subject = subject;
	}
	public int getRno() {
		return rno;
	}
	public String getName() {
		return name;
	}
	public double getMarks() {
		return marks;
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
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + ", subject=" + subject + "]";
	}
	
	
	
}
