package com.spring.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private String sname;
	private String capitalCity;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_cno", referencedColumnName = "cno")
	private ChiefMinister chiefMinister;

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(int sno, String sname, String capitalCity, ChiefMinister chiefMinister) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.capitalCity = capitalCity;
		this.chiefMinister = chiefMinister;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public ChiefMinister getChiefMinister() {
		return chiefMinister;
	}

	public void setChiefMinister(ChiefMinister chiefMinister) {
		this.chiefMinister = chiefMinister;
	}

	@Override
	public String toString() {
		return "State [sno=" + sno + ", sname=" + sname + ", capitalCity=" + capitalCity + ", chiefMinister="
				+ chiefMinister + "]";
	}

}
