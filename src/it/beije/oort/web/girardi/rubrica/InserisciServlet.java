package it.beije.oort.web.girardi.rubrica;
// http://localhost:8080/OortWeb/rubrica/menu.html

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.girardi.jpa.JPAfactory;
import it.beije.oort.web.girardi.jpa.RubricaJPA;

/**
 * Servlet implementation class menuServlet
 */
@WebServlet("/InserisciServlet")
public class InserisciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
			
//		entityManager.close();
//		RubricaJPA.inserisciContatto(c);
	
		response.getWriter().append("\n Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}