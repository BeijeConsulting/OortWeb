package it.beije.oort.madonia.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;

public class DatabaseManagerBiblioteca {
	private DatabaseManagerBiblioteca () {}
	
	private static String persistenceUnitName = "OortBiblioteca";
	
	public static Utente login(String email, String password) {
		EntityManager eManager = null;
		Query query = null;
		Utente utente = null;
		String jpql = "SELECT u FROM Utente as u WHERE email = :email AND password = :password";
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
			query = eManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			utente = (Utente) query.getSingleResult();
		} catch(NoResultException e) {
			utente = null;
		} finally {
			eManager.close();
		}
		
		return utente;
	}
	
	public static void inserisci(Autore autore) {
		if (autore == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Object) autore);
	}
	
	public static void inserisci(Utente utente) {
		if (utente == null) {
			throw new IllegalArgumentException("L'oggetto è vuoto");
		}
		inserisci((Object) utente);
	}
	
	private static void inserisci(Object o) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
		try {
			eManager.getTransaction().begin();
			eManager.persist(o);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static void modifica(Autore autore) {
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
		try {
			Autore autoreModifica = eManager.find(Autore.class, autore.getId());
			autoreModifica.setNome(autore.getNome());
			autoreModifica.setCognome(autore.getCognome());
			autoreModifica.setDataNascita(autore.getDataNascita());
			autoreModifica.setDataMorte(autore.getDataMorte());
			autoreModifica.setBiografia(autore.getBiografia());
			
			eManager.getTransaction().begin();
			eManager.persist(autoreModifica);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static Libro trovaLibro(int id) {
		EntityManager eManager = null;
		Libro libro = null;
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
			libro = eManager.find(Libro.class, id);
		} catch(NoResultException e) {
			libro = null;
		} finally {
			eManager.close();
		}
		
		return libro;
	}
	
	public static Autore trovaAutore(int id) {
		EntityManager eManager = null;
		Autore autore = null;
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
			autore = eManager.find(Autore.class, id);
		} catch(NoResultException e) {
			autore = null;
		} finally {
			eManager.close();
		}
		
		return autore;
	}
	
	public static List<Prestito> trovaPrestiti(Utente utente) {
		EntityManager eManager = null;
		Query query = null;
		List<Prestito> lista = null;
		String jpql = "SELECT p FROM Prestito as p WHERE utente = :idUtente";
		try {
			eManager = JpaEntityManagerFactory.createEntityManager(persistenceUnitName);
			query = eManager.createQuery(jpql);
			query.setParameter("idUtente", utente.getId());
			lista = query.getResultList();
		} catch(NoResultException e) {
			lista = null;
		} finally {
			eManager.close();
		}
		
		return lista;
	}
}
