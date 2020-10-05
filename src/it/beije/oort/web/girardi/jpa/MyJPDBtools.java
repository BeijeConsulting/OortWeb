package it.beije.oort.web.girardi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.oort.web.girardi.rubrica.Contatto;

public class MyJPDBtools {
	public static void main(String[] args) {

		//apro EntityManagerFactory
//		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OortRubrica");
		EntityManager entityManager = factory.createEntityManager();
	
		//esempio SELECT
//		Contatto contatto = entityManager.find(Contatto.class, 1);
//		
//		System.out.println(contatto);
		
		//esempio query JPQL
		String jpql = "SELECT c FROM Contatto as c WHERE cognome = 'bravo'";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		System.out.println(contatti.size());
		for (Contatto contatto : contatti) {
			System.out.println("id : " + contatto.getId());
			System.out.println("nome : " + contatto.getNome());
			System.out.println("cognome : " + contatto.getCognome());
			System.out.println("telefono : " + contatto.getTelefono());
			System.out.println("email : " + contatto.getEmail());
		}
		
//		//esempio INSERT
//		Contatto contatto = new Contatto();
//		contatto.setNome("Gianna");
//		contatto.setCognome("Nanni");
//		contatto.setEmail("gianna@nannino.it");
//		contatto.setTelefono("3455661634");
//		
//		//entityManager.getTransaction().begin();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		
//		System.out.println("contatto id : " + contatto.getId());
//		entityManager.persist(contatto);
//		System.out.println("contatto id : " + contatto.getId());
//		entityManager.getTransaction().commit();
//		//entityManager.getTransaction().rollback();
		
		entityManager.close();
	}

}
