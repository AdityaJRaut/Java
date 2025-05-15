package com.springcore.ci;

public class Address {

	private String state;
	private String city;
	
	public Address(String state, String city) {
		super();
		this.state = state;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}
	
	
	
}
