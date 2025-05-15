package com.spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		/* this factory object will be used to execute the database functions */

		System.out.println(factory);
		System.out.println(factory.isClosed());

	}
}
