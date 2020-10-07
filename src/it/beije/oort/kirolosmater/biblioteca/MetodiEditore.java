package it.beije.oort.kirolosmater.biblioteca;

import static it.beije.oort.kirolosmater.biblioteca.LibraryManager.libraryPersistenceUnit;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import it.beije.oort.kirolosmater.biblioteca.model.Autore;
import it.beije.oort.kirolosmater.biblioteca.model.Editore;
import it.beije.oort.kirolosmater.biblioteca.model.JPAEntityManagerSingleton;

public class MetodiEditore {
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(libraryPersistenceUnit);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Editore readRecordFromDb(int id) { 		
		Editore editore = entityManager.find(Editore.class, id);
		return editore;
	}
	
	public static List<Editore> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Editore as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Editore> editori = query.getResultList();
//		for (Editore editore : editori) {
//			System.out.println("id : " + editore.getId());			
//			System.out.println("denominazione : " + editore.getDenominazione());
//			System.out.println("descrizione : " + editore.getDescrizione());
//
//		}
		return editori;
	}
}
