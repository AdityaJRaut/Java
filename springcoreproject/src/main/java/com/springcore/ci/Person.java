package com.springcore.ci;

public class Person {
	
	private String fname;
	private String lname;
	private Address address;
	
	public Person(String fname, String lname, Address address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", address=" + address + "]";
	}

	
	
	
	

}
