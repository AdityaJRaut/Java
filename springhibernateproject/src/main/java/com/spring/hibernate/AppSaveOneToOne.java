package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.ChiefMinister;
import com.spring.hibernate.entity.State;

public class AppSaveOneToOne {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		ChiefMinister chiefMinister1 = new ChiefMinister();
		chiefMinister1.setCname("Dev Fadanvis");
		chiefMinister1.setAge(57);

		ChiefMinister chiefMinister2 = new ChiefMinister();
		chiefMinister2.setCname("BL Sharma");
		chiefMinister2.setAge(60);

		State state1 = new State();
		state1.setSname("Maharashhtra");
		state1.setCapitalCity("Mumbai");
		state1.setChiefMinister(chiefMinister1);

		State state2 = new State();
		state2.setSname("Rajastan");
		state2.setCapitalCity("Jaipur");
		state2.setChiefMinister(chiefMinister2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(state1);
		session.save(state2);
		tx.commit();

		session.close();
		factory.close();

	}
}
