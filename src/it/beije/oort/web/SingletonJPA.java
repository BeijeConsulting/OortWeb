package it.beije.oort.web;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonJPA {

		private SingletonJPA() {}
		
		private static EntityManagerFactory factory;

		
		public static EntityManager openEntity() {
			if(factory == null) {
				factory = Persistence.createEntityManagerFactory("OortRubrica");
					System.out.println("EntityFactory is create? " + factory.isOpen());
			}
		return	 factory.createEntityManager();
		}
		
	}


