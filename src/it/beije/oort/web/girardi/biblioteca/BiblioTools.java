package it.beije.oort.web.girardi.biblioteca;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.girardi.jpa.JPAfactoryBiblio;

public class BiblioTools {
	//apre EntityManagerFactory
	private static final EntityManager entityManager = JPAfactoryBiblio.openEntityFactory();
	
	
	public static Utente getUtente (String email, String password) throws IOException {		
		//query JPQL
		String jpql = "SELECT a FROM Utente as a WHERE email = '" + email + "' and "
						+ "password = '" + password + "'";
		Query query = entityManager.createQuery(jpql);
		List<Utente> listUtente = query.getResultList();
	
		if (listUtente.size() == 0) {
			System.out.println("Nessun utente corrisponde ai dati inseriti");
			return null;
		} else if (listUtente.size() > 1) 
			System.out.println("ALERT: Più di un utente corrisponde ai dati inseriti");
		
		Utente utente = listUtente.get(0);
		return utente;
		}
	

	public static void autenticazione (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente u = BiblioTools.getUtente(email, password);
		
		//verifico se coppia valori è OK
		if (email.equalsIgnoreCase(u.getEmail()) && password.equals(u.getPassword())) {
			Utente utente = new Utente();
			utente.setNome(u.getNome());
			utente.setCognome(u.getCognome());
			utente.setEmail(email);
			
			request.getSession().setAttribute("userBean", utente);
			response.sendRedirect("biblioteca.homepage.jsp");
		} else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("biblioteca.myLogin.jsp");
		}
		
	}
}













