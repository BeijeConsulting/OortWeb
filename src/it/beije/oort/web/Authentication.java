package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//verifico se coppia valori è OK
		//SELECT * from Utente where email = ? AND password = ?
		if (email.equalsIgnoreCase("pippo@pluto.it") && password.equals("123456")) {
			Utente utente = new Utente();
			utente.setNome("Pippo");
			utente.setCognome("Pluto");
			utente.setEmail(email);
			
			request.getSession().setAttribute("userBean", utente);
			response.sendRedirect("conferma.jsp");
		} else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("login.jsp");
		}
		
	}

}
