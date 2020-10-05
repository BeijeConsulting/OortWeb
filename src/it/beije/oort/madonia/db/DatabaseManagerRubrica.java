package it.beije.oort.madonia.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.beije.oort.madonia.rubrica.ebeans.Contatto;

public class DatabaseManagerRubrica {
	
	private final static String UNIT_NAME = "OortRubrica";
	
	public static void inserisciContatto(Contatto contatto) {
		if (contatto == null || contatto.isEmpty()) {
			throw new IllegalArgumentException("this argument is null or empty");
		}
		
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(UNIT_NAME);
		try {
			eManager.getTransaction().begin();
			eManager.persist(contatto);
			eManager.getTransaction().commit();
		} finally {
			eManager.close();
		}
	}
	
	public static List<Contatto> ottieniListaContatti(String nome, String cognome, String telefono, String email) {
		boolean addAnd = false;
		boolean addNome = nome != null && nome.length() > 0;
		boolean addCognome = cognome != null && cognome.length() > 0;
		boolean addTelefono = telefono != null && telefono.length() > 0;
		boolean addEmail = email != null && email.length() > 0;
		StringBuilder jpqlBuilder = new StringBuilder("SELECT c FROM Contatto as c ");
		
		if (addNome || addCognome || addTelefono || addEmail) {
			jpqlBuilder.append("WHERE ");
		}
		
		if (addNome) {
			jpqlBuilder.append("c.nome like :nome ");
			addAnd = true;
		}
		if (addCognome) {
			if (addAnd) { jpqlBuilder.append("AND "); }
			jpqlBuilder.append("c.cognome like :cognome ");
			addAnd = true;
		}
		if (addTelefono) {
			if (addAnd) { jpqlBuilder.append("AND "); }
			jpqlBuilder.append("c.telefono like :telefono ");
			addAnd = true;
		}
		if (addEmail) {
			if (addAnd) { jpqlBuilder.append("AND "); }
			jpqlBuilder.append("c.email like :email ");
		}
		
		jpqlBuilder.append("ORDER BY c.id");
		
		EntityManager eManager = JpaEntityManagerFactory.createEntityManager(UNIT_NAME);
		Query query = eManager.createQuery(jpqlBuilder.toString());
		if(addNome) { query.setParameter("nome", nome); }
		if(addCognome) { query.setParameter("cognome", cognome); }
		if(addTelefono) { query.setParameter("telefono", telefono); }
		if(addEmail) { query.setParameter("email", email); }
		
		return query.getResultList();
	}
	
}
