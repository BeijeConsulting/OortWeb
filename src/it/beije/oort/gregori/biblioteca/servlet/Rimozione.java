package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.gregori.biblioteca.jpa.Autore;
import it.beije.oort.gregori.biblioteca.jpa.AutoreUtility;
import it.beije.oort.gregori.biblioteca.jpa.Editore;
import it.beije.oort.gregori.biblioteca.jpa.EditoreUtility;
import it.beije.oort.gregori.biblioteca.jpa.JPAEntityManager;
import it.beije.oort.gregori.biblioteca.jpa.Libro;
import it.beije.oort.gregori.biblioteca.jpa.LibroUtility;
import it.beije.oort.gregori.biblioteca.jpa.Prestito;
import it.beije.oort.gregori.biblioteca.jpa.PrestitoUtility;
import it.beije.oort.gregori.biblioteca.jpa.Utente;
import it.beije.oort.gregori.biblioteca.jpa.UtenteUtility;

/**
 * Servlet implementation class Rimozione
 */
@WebServlet("/Rimozione")
public class Rimozione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rimozione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String tabella = request.getParameter("selezione-tabella");
		HttpSession session = request.getSession();
		
		session.setAttribute("tabella", tabella);
		
		switch(tabella) {
		
			case "utente":
				List<Utente> utenti = UtenteUtility.visualizza();
				session.setAttribute("utenti", utenti);
			break;
			
			case "autore":
				List<Autore> autori = AutoreUtility.visualizza();
				session.setAttribute("autori", autori);
				break;
				
			case "editore":
				List<Editore> editori = EditoreUtility.visualizza();
				session.setAttribute("editori", editori);
				break;
				
			case "prestito":
				List<Prestito> prestiti = PrestitoUtility.visualizza();
				session.setAttribute("prestiti", prestiti);
				break;
				
			case "libro":
				List<Libro> libri = LibroUtility.visualizza();
				session.setAttribute("libri", libri);
				break;
		
		}
		response.sendRedirect("./biblioteca/eliminazione.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String checkbox = request.getParameter("checkbox");
		
		String jpaql = "SELECT id FROM Utente";
		
		EntityManager entityManager =  JPAEntityManager.createEntityManager();
		List<Integer> ids = entityManager.createQuery(jpaql).getResultList();
		
		if(ids.contains(Integer.parseInt(checkbox))) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(entityManager.find(Utente.class, Integer.parseInt(checkbox)));
			entityManager.getTransaction().commit();
			entityManager.close();		
		}
		
		response.sendRedirect("./biblioteca/eliminazione.jsp");
	}

}
