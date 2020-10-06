package it.beije.oort.kirolosmater.rubrica;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;

import it.beije.oort.kirolosmater.biblioteca.Autore;
import it.beije.oort.kirolosmater.biblioteca.JPAEntityManagerSingleton;
import it.beije.oort.rubrica.Contatto;

public class RubricaJpa {
	public static String RUBRICA_PERSISTENCE_UNIT = "OortRubrica";
	static EntityManager entityManager = JPAEntityManagerSingleton.getEntityManager(RUBRICA_PERSISTENCE_UNIT);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(readRecordFromDb(7));
//		System.out.println(readRecordByStringFromInput("nome", "kiro"));
	}
	
	public static Contatto readRecordFromDb(int id) { 		
		Contatto contatto = entityManager.find(Contatto.class, id);
		return contatto;
	}
	
	public static List<Contatto> readRecordByStringFromInput (String parametro, String stringaIniziale) {
		String parameter = parametro;
		String lineFromInput = stringaIniziale;
		String jpql = "SELECT c FROM Contatto as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());	
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		return contatti;
	}
	
	public static List<Contatto> readRecordByStringFromInput () {
		Scanner inputFromUser = new Scanner(System.in);
		System.out.println("Inserisci il parametro da analizzare: ");
		String parameter = inputFromUser.nextLine();
		String stringRequest = "Inserisci la stringa iniziale: ";
		System.out.println(stringRequest);
		String lineFromInput = inputFromUser.nextLine();
		String jpql = "SELECT c FROM rubrica as c WHERE " + parameter + " LIKE '" + lineFromInput + "%'";
		Query query = (Query) entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());	
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		return contatti;
	}
	
}
