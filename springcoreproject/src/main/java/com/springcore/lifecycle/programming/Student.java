package com.springcore.lifecycle.programming;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean,DisposableBean {

	private int rno;
	private String name;
	private double marks;

	public Student() {
	}

	public Student(int rno, String name, double marks) {
		super();
		this.rno = rno;
		this.name = name;
		this.marks = marks;
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

	public void setRno(int rno) {
		this.rno = rno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", marks=" + marks + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("programming approach inside destroy method");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("programming approach inside afterpropertiesset method");
		
	}

}
