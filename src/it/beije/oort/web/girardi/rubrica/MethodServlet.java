package it.beije.oort.web.girardi.rubrica;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.girardi.jpa.JPAfactory;

public class MethodServlet {
//menu iniziale, visualizza, modifica, cancella, inserisci Contatto:
	
	public static void menu (HttpServletResponse response) throws IOException {
		StringBuilder menu = new StringBuilder("<!DOCTYPE html>");
		menu.append("<html><head><meta charset=\\\"ISO-8859-1\\\"><title>OortWeb</title></head><body>")
			.append("<br><a href=\"http://localhost:8080/OortWeb/rubrica/"
					+ "menu.html\">Ritorna al menu iniziale</a><br>")
			.append("</body></html>");
		response.getWriter().append(menu);
	}
	

	public static List<Contatto> visualizzaTutti (HttpServletResponse response) 
				throws ServletException, IOException {
		//apro EntityManagerFactory 
		EntityManager entityManager = JPAfactory.openEntityFactory();

		//query JPQL
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> listContatti = query.getResultList();
		
		StringBuilder strb = new StringBuilder("totale contatti: ");
		strb.append(listContatti.size());
		for (Contatto contatto : listContatti) {
			strb.append("\n").append(contatto);
		}
		response.getWriter().append(strb);
		return listContatti;
	}

	
	public static Contatto visualizzaId (HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String parametro = request.getParameter("id");
		if (parametro.equals("")) {
			response.getWriter().append("Non hai effettuato alcuna selezione");
			return null;
		} else {
			try {
			int id = Integer.parseInt(request.getParameter("id"));			
			//apro EntityManagerFactory
			EntityManager entityManager = JPAfactory.openEntityFactory();
			//SELECT
			request.getParameter("id");
			Contatto contatto = entityManager.find(Contatto.class, id);
			
			StringBuilder strb = new StringBuilder().append(contatto);
			response.getWriter().append(strb);
			return contatto;
			} catch (NumberFormatException nfe) {
				response.getWriter().append("Non hai inserito un numero");
				return null;
			}
		}
	}
	
	
	public static void modificaContatto (HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		Contatto contatto = MethodServlet.visualizzaId(request, response);
		if (contatto == null) {
			System.out.println("non sono presenti contatti con l'id richiesto");
			return;
		}
	
		//cognome, nome, telefono, email
		String nome = request.getParameter("nome");
		if (!(nome.contentEquals("")))
			contatto.setNome(nome);
		
		String cognome = request.getParameter("cognome");
		if (!(cognome.contentEquals("")))
			contatto.setCognome(cognome);
		
		String telefono = request.getParameter("telefono");
		if (!(telefono.contentEquals("")))
			contatto.setTelefono(telefono);
		
		String email = request.getParameter("email");
		if (!(email.contentEquals("")))
			contatto.setEmail(email);
		
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//apro transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(contatto); //UPDATE
		entityManager.getTransaction().commit();
		
		response.getWriter().append("Contatto aggiornato con successo:\n"+ contatto);	
	}
	
	
	public static void cancellaContatto (HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		Contatto contatto = MethodServlet.visualizzaId(request, response);
		if (contatto == null) {
			response.getWriter().append("non sono presenti contatti con l'id richiesto");
			return;
		}
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//apro transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
				
		//entityManager.remove(entityManager.find(Contatto.class, id));
		entityManager.remove(contatto);
		entityManager.getTransaction().commit();
		
		response.getWriter().append("contatto eliminato");
	}
	
	
	public static void inserisciContatto(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// nome cognome telefono email		
		Contatto c = new Contatto(request.getParameter("nome"),request.getParameter("cognome"),
							request.getParameter("telefono"), request.getParameter("email"));
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();
		
		//entityManager.getTransaction().begin();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	
		if (c.getNome().trim().equals("") && c.getCognome().trim().equals("") &&
			c.getTelefono().trim().equals("") && c.getEmail().trim().equals("") ) {
			response.getWriter().append("ALERT: il contatto è vuoto e non verrà inserito\n");
			//annullo transizione
			entityManager.getTransaction().rollback();
		} else {
			entityManager.persist(c);
			//confermo aggiornamento su DB
			entityManager.getTransaction().commit();
			response.getWriter().append("contatto inserito con successo! \n " + c)
								.append("\n id assegnato: " + c.getId());
		}		
	}
}
