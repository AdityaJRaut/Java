package com.springcore.component;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String state;
	private String city;

	public Address(String state, String city) {
		super();
		this.state = state;
		this.city = city;
	}

	public Address() {
		this.state = "Maharashtra";
		this.city = "Kolhapur";
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}

}
