package it.beije.oort.web.girardi.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Transaction;

import it.beije.oort.web.girardi.rubrica.Contatto;

public class RubricaJPA {

// ------------ METODI ------------
//1)VISUALIZZA;  2)MODIFICA/CANCELLA;  3)INSERIMENTO; 4)ESPORTA
	
//1) VISUALIZZA
	public static void visualizzaTutti() {
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//query JPQL
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		System.out.println(contatti.size());
		for (Contatto contatto : contatti) {
			System.out.println(contatto);
		}
		entityManager.close();
	}
	
	public static void visualizzaId(int id) {
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//SELECT
		Contatto contatto = entityManager.find(Contatto.class, id);
		System.out.println(contatto);
		
		entityManager.close();
	}
	
//2) MODIFICA/CANCELLA
	public static void modificaContatto(int id) {
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		//SELECT
		Contatto contatto = entityManager.find(Contatto.class, id);
		System.out.println(contatto);
		if (contatto == null) {
			System.out.println("non sono presenti contatti con l'id richiesto");
			entityManager.close();
			return;
		}
				
		Scanner myInput = new Scanner(System.in);  //apre lo scanner
		String input = ""; 
	
		//cognome, nome, telefono, email
		System.out.println("inserire i campi relativi al contatto:");
		System.out.println("(se non si vuole cambiare un campo premere invio)");
		System.out.print("\t inserire il nome: ");
		input = myInput.nextLine();
		if (!(input.contentEquals("")))
			contatto.setNome(input);
		System.out.print("\t inserire il cognome: ");
		input = myInput.nextLine();
		if (!(input.contentEquals("")))
			contatto.setCognome(input);
		System.out.print("\t inserire il telefono: ");
		input = myInput.nextLine();
		if (!(input.contentEquals("")))
			contatto.setTelefono(input);
		System.out.print("\t inserire la email: ");
		input = myInput.nextLine();
		if (!(input.contentEquals("")))
			contatto.setEmail(input);
		
		System.out.println(contatto);
		
		//query JPQL
		String jpql = "UPDATE c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
			
		System.gc();
			
	}
	
	
//3) INSERIMENTO	
	public static void inserisciContatto(Contatto c) {	
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//entityManager.getTransaction().begin();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	
		if (c.getNome().trim().equals("") && c.getCognome().trim().equals("") &&
			c.getTelefono().trim().equals("") && c.getEmail().trim().equals("") ) {
			System.out.println("ALERT: il contatto è vuoto e non verrà inserito\n");
			//annullo transizione
			entityManager.getTransaction().rollback();
		} else {
			entityManager.persist(c);
			System.out.println("id assegnato: " + c.getId());
			System.out.println("contatto inserito: " + c);
			//confermo aggiornamento su DB
			entityManager.getTransaction().commit();
		}
		entityManager.close();
	}
	
//4) ESPORTA
	
}
