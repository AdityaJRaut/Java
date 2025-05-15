package com.springcore.autowire.type;

public class Subject {

	private String subjectName;
	public Subject() {}
	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
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
