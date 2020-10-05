package it.beije.oort.kirolosmater.rubrica;

import javax.persistence.EntityManager;

import it.beije.oort.kirolosmater.biblioteca.JPAEntityManagerSingleton;
import it.beije.oort.rubrica.Contatto;

public class RubricaJpa {
	public static String RUBRICA_PERSISTENCE_UNIT = "OortRubrica";
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(RUBRICA_PERSISTENCE_UNIT);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(readRecordFromDb(7));
	}
	
	public static Contatto readRecordFromDb(int id) { 		
		Contatto contatto = entityManager.find(Contatto.class, id);
		return contatto;
	}
}
