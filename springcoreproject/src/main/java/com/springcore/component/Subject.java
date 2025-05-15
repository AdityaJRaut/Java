package com.springcore.component;

import org.springframework.stereotype.Component;

@Component
public class Subject {

	private String subjectName;

	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}

	public Subject() {
		this.subjectName="maths";
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + "]";
	}
	
	
}
