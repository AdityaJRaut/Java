package com.spring.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChiefMinister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cno;
	private String cname;
	private int age;

	public ChiefMinister() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiefMinister(int cno, String cname, int age) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.age = age;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ChiefMinister [cno=" + cno + ", cname=" + cname + ", age=" + age + "]";
	}

}
