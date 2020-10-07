package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.gregori.biblioteca.jpa.JPAEntityManager;
import it.beije.oort.gregori.biblioteca.jpa.Utente;

/**
 * Servlet implementation class InserimentoController
 */
@WebServlet("/InserimentoController")
public class InserimentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tabella = request.getParameter("selezione-tabella");
//		HttpSession session = request.getSession();
//		session.setAttribute("tabella", tabella);
		
		switch(tabella) {
			case "utente":
				response.sendRedirect("./biblioteca/inserimento-utente.jsp");
			break;
		
		}
//		response.sendRedirect("./biblioteca/inserimento.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String page = request.getParameter("page");
		HttpSession session = request.getSession();
		session.setAttribute("page", "utente");
		
		switch(page) {
		case "utente":
			String nome = request.getParameter("name");
			String cognome = request.getParameter("surname");
			String codiceFiscale = request.getParameter("codice-fiscale");
			String indirizzo = request.getParameter("indirizzo");
			String email = request.getParameter("email");
			String telefono = request.getParameter("phone");
			String password = request.getParameter("password");
			
			Utente utente = new Utente();
			utente.setNome(nome);
			utente.setCognome(cognome);
			utente.setCodiceFiscale(codiceFiscale);
			utente.setEmail(email);
			utente.setIndirizzo(indirizzo);
			utente.setTelefono(telefono);
			utente.setPassword(password);
			
			session.setAttribute("utente", utente);
			
			EntityManager entityManager = JPAEntityManager.createEntityManager();
			
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(utente);
			entityManager.getTransaction().commit();
			
			entityManager.close();	

			response.sendRedirect("./biblioteca/inserimento-utente.jsp");
		break;
	
	}
	}

}
