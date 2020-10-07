package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.*;
import static it.beije.oort.kirolosmater.biblioteca.MetodiPrestito.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.model.Utente;

/**
 * Servlet implementation class AutenticazioneServlet
 */
@WebServlet("/biblioteca/view/AutenticazioneServlet")
public class AutenticazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticazioneServlet() {
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
//		doGet(request, response);
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = checkEmail(email);
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			session.setAttribute("userBean", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			session.setAttribute("prestitiUserBean", prestitiUtente);
			boolean admin = utente.isAdmin();
//			System.out.println(admin);
			session.setAttribute("userIsAdmin", admin);
			response.sendRedirect("areaPersonaleUtente.jsp");
		} else {
			session.setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("loginUtente.jsp");
		}
	}
	
	

}
