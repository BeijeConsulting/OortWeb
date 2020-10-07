package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.gregori.biblioteca.jpa.Utente;
import it.beije.oort.gregori.biblioteca.jpa.JPAEntityManager;
import it.beije.oort.gregori.biblioteca.jpa.Libro;
import it.beije.oort.gregori.biblioteca.jpa.Prestito;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String email = request.getParameter("username");
		String password = request.getParameter("pass");
		
		Utente utente = new Utente();
		utente.setEmail(email);
		utente.setPassword(password);		
		
		HttpSession session = request.getSession();
//		session.setAttribute("utente", utente);
		
		String jpaql = "SELECT u FROM Utente as u WHERE email = '" + email + "' AND password = '" + password + "'";
		
		EntityManager entityManager =  JPAEntityManager.createEntityManager();
		List<Utente> utenti = entityManager.createQuery(jpaql).getResultList();
		
		
		
		if(utenti.size() == 0) {
			session.setAttribute("errore", "Dati inseriti non corretti!");
			response.sendRedirect("./biblioteca/login/login.jsp");
			entityManager.close();
		}
		else {
			if (utenti.get(0).isAdmin()) {
				response.sendRedirect("./biblioteca/home.html");
				entityManager.close();
			}
			else
			{
				jpaql = "SELECT p FROM Prestito as p WHERE id_utente = '" + utenti.get(0).getId() + "'";
				List<Prestito> prestiti = entityManager.createQuery(jpaql).getResultList();
				session.setAttribute("prestiti", prestiti);
				
				jpaql = "SELECT l FROM Libro as l";
				List<Libro> libri = entityManager.createQuery(jpaql).getResultList();
				session.setAttribute("libri", libri);
				
				entityManager.close();
				response.sendRedirect("./biblioteca/visualizza.jsp");
			}
		}
		
	}

}
