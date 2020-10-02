package it.beije.oort.sala.web.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	private static EntityManagerFactory factory;
	public static EntityManager createEntityManager() {
		if(factory==null) {
			factory = Persistence.createEntityManagerFactory("Rubrica");
		}
		return factory.createEntityManager();
	}
}
