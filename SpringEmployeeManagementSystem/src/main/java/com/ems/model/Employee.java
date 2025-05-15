package com.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String empDept;
	private String empGender;
	private String empDob;

	public Employee(String empName, String empDept, String empGender, String empDob) {
		
		this.empName = empName;
		this.empDept = empDept;
		this.empGender = empGender;
		this.empDob = empDob;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpDob() {
		return empDob;
	}

	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}

	@Override
	public String toString() {
		return "Employee [ empName=" + empName + ", empDept=" + empDept + ", empGender=" + empGender
				+ ", empDob=" + empDob + "]";
	}

}
