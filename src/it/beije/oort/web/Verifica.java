package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.biblioteca.Editori;
import it.beije.oort.sb.biblioteca.Autori;
import java.util.List;

import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class Verifica
 */
@WebServlet("/Verifica")
public class Verifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verifica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		//nel caso venga chiamato per il login	
		if(email!=null && password !=null) {
		Utenti utente = JPDBtools.ricercaUtente(email, password);
		if(utente==null) {session.setAttribute("errore", "Credenziali Errate");
		response.sendRedirect("login.jsp"); }
		else { 
			session.setAttribute("utente", utente);
			session.setAttribute("login", "true");
			if(utente.isAdmin()) session.setAttribute("admin", "on");
			else session.setAttribute("admin", "off");
			response.sendRedirect("menubiblioteca.jsp");
				
				}
			}
		}
	}

		


