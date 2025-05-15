package com.spring.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.entity.Actor;
import com.spring.hibernate.entity.Movie;

public class AppSaveManyToMany {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Actor actor1 = Actor.builder().actorName("SRK").actorAge(59).build();

		Actor actor2 = Actor.builder().actorName("DP").actorAge(40).build();

		Actor actor3 = Actor.builder().actorName("Akshay").actorAge(57).build();

		Movie movie1 = Movie.builder().movieName("CE").releaseYear(2010).build();

		Movie movie2 = Movie.builder().movieName("DON").releaseYear(2007).build();

		Movie movie3 = Movie.builder().movieName("RR").releaseYear(2006).build();

		List<Movie> srkMovies = new ArrayList<Movie>();
		srkMovies.add(movie1);
		srkMovies.add(movie2);

		List<Movie> dpMovies = new ArrayList<Movie>();
		dpMovies.add(movie1);

		List<Movie> akMovies = new ArrayList<Movie>();
		akMovies.add(movie3);

		actor1.setPortfolio(srkMovies);
		actor2.setPortfolio(dpMovies);
		actor3.setPortfolio(akMovies);

		session.save(actor1);
		session.save(actor2);
		session.save(actor3);

		tx.commit();

		session.close();
		factory.close();
	}
}
