package it.beije.oort.gregori.rubrica.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManager {

	private static EntityManagerFactory factory;
	
	private JPAEntityManager() {}
	
	public static EntityManager createEntityManager() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("OortRubrica");
			System.out.println("EntityManager is create? " + factory.isOpen());
		}
		
		return factory.createEntityManager();
	}	
	
	public static EntityManager createEntityManager(String s) {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(s);
			System.out.println("EntityManager is create? " + factory.isOpen());
		}
		
		return factory.createEntityManager();
	}	
}
