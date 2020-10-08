package it.beije.oort.lauria.rubrica;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.beije.oort.lauria.biblioteca.JEntityManagerFactory;

public class JPADBtoolsRubrica {

	public static final EntityManager entityManager = JEntityManagerFactory.openEntityManager("OortRubrica");
	
	public static void insertContact(String nome, String cognome, String telefono, String email) {
		//EntityManager entityManager = JEntityManagerFactory.openEntityManager("OortRubrica");
		Contatto contatto = new Contatto();
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		
		// apro la transaction
		entityManager.getTransaction().begin();
		// salvo il libro
		entityManager.persist(contatto);
		// chiudo la transaction
		entityManager.getTransaction().commit();
		//entityManager.close();
					
	}
	
	public static void updateContact(int id, String nome, String cognome, String telefono, String email) {
		
		Contatto contatto = entityManager.find(Contatto.class, id);
		//System.out.println("Contatto corrente da modificare : "+ + contatto.getId() + " - " + contatto);
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		//System.out.println("Contatto modificato : "+ + contatto.getId() + " - " + contatto);
		
		// apro la transaction
		JPADBtoolsRubrica.entityManager.getTransaction().begin();
		// salvo il libro
		JPADBtoolsRubrica.entityManager.persist(contatto);
		// chiudo la transaction
		JPADBtoolsRubrica.entityManager.getTransaction().commit();
		
	}

	public static List<Contatto> selectContacts(String nome, String cognome, String telefono, String email) {

		String jpql = "SELECT c FROM Contatto as c WHERE cognome like '%"+ cognome +"%' and nome like '%"+ nome +"%' and telefono like '%"+ telefono +"%' and email like '%"+ email +"%'";
		//String hql = "SELECT c FROM Contatto as c WHERE email like '%@hotmail.it%'";		
		Query query = JPADBtoolsRubrica.entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();		
		return contatti;
	}

	public static List<Contatto> selectContacts() {

		String jpql = "SELECT c FROM Contatto as c WHERE id > 0";
		//String hql = "SELECT c FROM Contatto as c WHERE email like '%@hotmail.it%'";		
		Query query = JPADBtoolsRubrica.entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();		
		return contatti;
		
	}

	public static void deleteContact(int id){
		
		Contatto contatto = entityManager.find(Contatto.class, id);		
		
		// apro la transaction
		JPADBtoolsRubrica.entityManager.getTransaction().begin();
		// salvo il libro
		JPADBtoolsRubrica.entityManager.remove(contatto);
		// chiudo la transaction
		JPADBtoolsRubrica.entityManager.getTransaction().commit();
	}
}
