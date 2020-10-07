package it.beije.oort.web.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import it.beije.oort.web.db.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JPDBUtilities {
	
	public static void insertRecord(String cognome, String nome, String telefono, String email) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Contatto contact = new Contatto();
		contact.setCognome(cognome);
		contact.setNome(nome);
		contact.setTelefono(telefono);
		contact.setEmail(email);
		entityManager.persist(contact);
		transaction.commit();
		entityManager.close();
	}
	
	public static Libro exportBook(String titolo) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT l FROM Libro AS l WHERE titolo = '" + titolo + "'";
		Query query = entityManager.createQuery(jpql);
		Libro book = (Libro)query.getSingleResult();
		return book;
	}
	
	public static List<Libro> exportBooks(int idUtente) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT p FROM Prestito AS p WHERE id_utente = " + idUtente;
		Query query = entityManager.createQuery(jpql);
		List<Prestito> userLoans = query.getResultList();
		List<Libro> userBooks = new ArrayList<Libro>();
		for (int i = 0; i < userLoans.size(); i++) {
			String jpql2 = "SELECT l FROM Libro AS l WHERE id = " + userLoans.get(i).getId_libro();
			Query query2 = entityManager.createQuery(jpql2);
			Libro book = (Libro)query2.getSingleResult();
			userBooks.add(book);
		}
		return userBooks;
	}
	
	public static List<Libro> exportBooks() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT l FROM Libro l";
		Query query = entityManager.createQuery(jpql);
		List<Libro> books = query.getResultList();
		entityManager.close();
		return books;
	}
	
	public static List<Prestito> exportLoans() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT p FROM Prestito p";
		Query query = entityManager.createQuery(jpql);
		List<Prestito> loans = query.getResultList();
		entityManager.close();
		return loans;
	}
	
	public static List<Prestito> exportLoans(int idUtente) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT p FROM Prestito p where id_utente = " + idUtente;
		Query query = entityManager.createQuery(jpql);
		List<Prestito> loans = query.getResultList();
		entityManager.close();
		return loans;
	}
	
	public static boolean isAvalaible(int idUtente, int idLibro) {
		List<Prestito> loans = exportLoans();
		for (int i = 0; i < loans.size(); i++) {
			if (loans.get(i).getId_libro() == idLibro) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Contatto> exportRecords() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT c FROM Contatto c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contacts = query.getResultList();
		entityManager.close();
		return contacts;
	}
	
	public static Contatto exportContact(int id) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT c FROM Contatto AS c WHERE id = " + id;
		Query query = entityManager.createQuery(jpql);
		Contatto contact = (Contatto) query.getSingleResult();
		return contact;
	}
	
	public static boolean checkLogin(String email, String password) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User AS u WHERE password = '" + password + "' and email = '" + email + "'";
		Query query = entityManager.createQuery(jpql);
		try {
			User user = (User)query.getSingleResult();
			return true;
		} catch (javax.persistence.NoResultException e) {
			return false;
		}
	}
	
	public static User exportLoggedUser(String email, String password) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT u FROM User AS u WHERE password = '" + password + "' and email = '" + email + "'";
		Query query = entityManager.createQuery(jpql);
		User user = (User)query.getSingleResult();
		return user;
	}
	
	public static List<Autore> exportAuthors() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT a FROM Autore a";
		Query query = entityManager.createQuery(jpql);
		List<Autore> authors = query.getResultList();
		entityManager.close();
		return authors;
	}
	
	public static List<Editore> exportPublishers() {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		String jpql = "SELECT e from Editore e";
		Query query = entityManager.createQuery(jpql);
		List <Editore> publishers = query.getResultList();
		entityManager.close();
		return publishers;
	}
	
	public static void insertAuthor(String cognome, String nome, String data_nascita, String data_morte, String biografia) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Autore author = new Autore();
		author.setCognome(cognome);
		author.setNome(nome);
		author.setData_nascita(data_nascita);
		author.setData_morte(data_morte);
		author.setBiografia(biografia);
		entityManager.persist(author);
		transaction.commit();
		entityManager.close();
	}
	
	public static void insertPublisher(String denominazione, String descrizione) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Editore publisher = new Editore();
		publisher.setDenominazione(denominazione);
		publisher.setDescrizione(descrizione);
		entityManager.persist(publisher);
		transaction.commit();
		entityManager.close();
	}
	
	public static void insertBook(String titolo, String descrizione, int id_autore, int id_editore, int anno) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Libro book = new Libro();
		book.setTitolo(titolo);
		book.setDescrizione(descrizione);
		book.setId_autore(id_autore);
		book.setId_editore(id_editore);
		book.setAnno(anno);
		entityManager.persist(book);
		transaction.commit();
		entityManager.close();
	}
	
	public static void insertUser(String nome, String cognome, String telefono, String email, String codice_fiscale, String indirizzo) {
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		User user = new User();
		user.setNome(nome);
		user.setCognome(cognome);
		user.setTelefono(telefono);
		user.setEmail(email);
		user.setCodice_fiscale(codice_fiscale);
		user.setIndirizzo(indirizzo);
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();
	}
	
	public static String insertLoan(int idLibro, int idUtente, LocalDate data_inizio, LocalDate data_fine, String note) {
		String message = new String();
		EntityManager entityManager = JPDBEntityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		if (isAvalaible(idUtente, idLibro)) {
			Prestito loan = new Prestito();
			loan.setId_libro(idLibro);
			loan.setId_utente(idUtente);
			loan.setData_inizio(data_inizio);
			loan.setData_fine(data_fine);
			loan.setNote(note);
			entityManager.persist(loan);
			transaction.commit();
			message = "Nuovo prestito registrato!";
		} else {
			transaction.rollback();
			message = "Libro non disponibile.";
		}
		return message;
	}
}
