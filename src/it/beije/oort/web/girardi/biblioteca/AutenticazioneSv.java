package it.beije.oort.web.girardi.biblioteca;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/autenticazione")
public class AutenticazioneSv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		BiblioTools.autenticazione(request,response);
		
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
			response.sendRedirect("biblioteca/homepage.jsp");
		} else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("biblioteca/myLogin.jsp");
		}
	}

}
