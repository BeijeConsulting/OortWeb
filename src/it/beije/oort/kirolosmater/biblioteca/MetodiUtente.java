package it.beije.oort.kirolosmater.biblioteca;

import static it.beije.oort.kirolosmater.biblioteca.LibraryManager.libraryPersistenceUnit;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.readRecordByStringFromInput;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import it.beije.oort.kirolosmater.biblioteca.model.JPAEntityManagerSingleton;
import it.beije.oort.kirolosmater.biblioteca.model.Utente;

public class MetodiUtente {
	
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(libraryPersistenceUnit);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Utente readRecordFromDb(int id) { 		
		Utente utente = entityManager.find(Utente.class, id);
		return utente;
	}
	
	public static void visualizzaUtenteById () {
		String showRecordById = "Per visualizzare un autore inserisci il suo id: ";
		System.out.println(showRecordById);
		Scanner inputFromUser = new Scanner(System.in);
		String lineFromInput = inputFromUser.next();
		int id = Integer.parseInt(lineFromInput);
		System.out.println("hai inserito questo id: " + id);
		System.out.println("questo è il record: ");
		Utente utente = readRecordFromDb(id);
//		System.out.println("id : " + utente.getId());			
//		System.out.println("cognome : " + utente.getCognome());
//		System.out.println("nome : " + utente.getNome());
//		System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//		System.out.println("email : " + utente.getEmail());
//		System.out.println("telefono : " + utente.getTelefono());
//		System.out.println("indirizzo : " + utente.getIndirizzo());
	}
	
	public static List<Utente> readRecordByStringFromInput () {
		Scanner inputFromUser = new Scanner(System.in);
		System.out.println("Inserisci il parametro da analizzare: ");
		String parameter = inputFromUser.nextLine();
		String stringRequest = "Inserisci la stringa iniziale: ";
		System.out.println(stringRequest);
		String lineFromInput = inputFromUser.nextLine();
		String jpql = "SELECT c FROM Utente as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Utente> utenti = query.getResultList();
//		for (Utente utente : utenti) {
//			System.out.println("id : " + utente.getId());			
//			System.out.println("cognome : " + utente.getCognome());
//			System.out.println("nome : " + utente.getNome());
//			System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//			System.out.println("email : " + utente.getEmail());
//			System.out.println("telefono : " + utente.getTelefono());
//			System.out.println("indirizzo : " + utente.getIndirizzo());
//		}
		return utenti;
	}
	
	public static List<Utente> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Utente as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Utente> utenti = query.getResultList();
//		for (Utente utente : utenti) {
//			System.out.println("id : " + utente.getId());			
//			System.out.println("cognome : " + utente.getCognome());
//			System.out.println("nome : " + utente.getNome());
//			System.out.println("codice_fiscale : " + utente.getCodice_fiscale());
//			System.out.println("email : " + utente.getEmail());
//			System.out.println("telefono : " + utente.getTelefono());
//			System.out.println("indirizzo : " + utente.getIndirizzo());
//		}
		return utenti;
	}
	
	public static Utente checkEmail (String email) {
		Utente utente = new Utente();
		List<Utente> utenti = readRecordByStringFromInput("email", email);
		utente = utenti.get(0);
		return utente;
	}
	
	public static boolean checkPassword (Utente utente, String password) {
		boolean passwordCorretta = false;
		passwordCorretta = password.equals(utente.getPassword());
		return passwordCorretta;
	}
}
