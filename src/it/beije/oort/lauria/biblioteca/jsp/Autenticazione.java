package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Utente;

/**
 * Servlet implementation class Autenticazione
 */
@WebServlet("/Autenticazione")
public class Autenticazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//verifico se coppia valori è OK
		//SELECT * from Utente where email = ? AND password = ?
		Utente utente = JPADBtools.verifyUtenti(email, password);
		if(utente != null) {
			request.getSession().setAttribute("userBean", utente);
			response.sendRedirect("confermaLogin.jsp");
		}else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("loginBiblio.jsp");
		}
		
		
		
//		if (email.equalsIgnoreCase("pippo@pluto.it") && password.equals("123456")) {
//			Utente utente = new Utente();
//			utente.setNome("Pippo");
//			utente.setCognome("Pluto");
//			utente.setEmail(email);
//			
//			request.getSession().setAttribute("userBean", utente);
//			response.sendRedirect("conferma.jsp");
//		} else {
//			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
//			response.sendRedirect("login.jsp");
//		}
		
	}

}
