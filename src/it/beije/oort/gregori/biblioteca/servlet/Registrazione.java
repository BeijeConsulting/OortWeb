package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Utilities;

import it.beije.oort.gregori.biblioteca.jpa.JPAEntityManager;
import it.beije.oort.gregori.biblioteca.jpa.Utente;
import it.beije.oort.gregori.biblioteca.jpa.UtenteUtility;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codiceFiscale = request.getParameter("codice-fiscale");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String indirizzo = request.getParameter("indirizzo");
		String telefono = request.getParameter("telefono");	
		
		Utente utente = new Utente();
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setEmail(email);
		utente.setCodiceFiscale(codiceFiscale);
		utente.setIndirizzo(indirizzo);
		utente.setTelefono(telefono);
		utente.setPassword(password);
		
		EntityManager entityManager = JPAEntityManager.createEntityManager();
		
		String query = "SELECT u FROM Utente as u WHERE email = '" + email + "'";
		List<Utente> utenti = entityManager.createQuery(query).getResultList();
		
		if(utenti.size() == 0) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(utente);
			entityManager.getTransaction().commit();
			
			entityManager.close();			
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("errore-registrazione", "errore-registrazione");	
		}
		
		response.sendRedirect("./biblioteca/login/confermaRegistrazione.jsp");		
	}

}
