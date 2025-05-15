package com.aditya.model;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private String dept;
	private String gender;
	private String dob;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	public String getGender() {
		return gender;
	}
	public String getDob() {
		return dob;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
}
