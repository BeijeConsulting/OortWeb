package it.beije.oort.kirolosmater.biblioteca;

import static it.beije.oort.kirolosmater.biblioteca.LibraryManager.libraryPersistenceUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import it.beije.oort.kirolosmater.biblioteca.model.Autore;
import it.beije.oort.kirolosmater.biblioteca.model.JPAEntityManagerSingleton;
import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.model.Utente;

public class MetodiPrestito {
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(libraryPersistenceUnit);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Prestito readRecordFromDb(int id) { 		
		Prestito prestito = entityManager.find(Prestito.class, id);
		return prestito;
	}
	
	public static List<Prestito> visualizzaPrestitiByIdUtente (Utente utente) {
		int idutente = utente.getId();
		String jpql = "SELECT a FROM Prestito a ORDER BY a.id";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Prestito> prestiti = query.getResultList();
		List<Prestito> prestitiUtente = new ArrayList<Prestito>();
		for (Prestito prestito : prestiti) {
			if(idutente == Integer.parseInt(prestito.getUtente())) {
				prestitiUtente.add(prestito);
			}
		}
		return prestitiUtente;
	}
	
	public static List<Prestito> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Prestito as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Prestito> prestiti = query.getResultList();
//		for (Autore autore : autori) {
//			System.out.println("id : " + autore.getId());			
//			System.out.println("cognome : " + autore.getCognome());
//			System.out.println("nome : " + autore.getNome());
//			System.out.println("data_nascita : " + autore.getData_nascita());
//			System.out.println("data_morte : " + autore.getData_morte());
//			System.out.println("biografia : " + autore.getBiografia());
//		}
		return prestiti;
	}
}
