package it.beije.oort.madonia.biblioteca.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;
import it.beije.oort.madonia.db.DatabaseManagerRubrica;

/**
 * Servlet implementation class LoginBibliotecaServlet
 */
@WebServlet("/biblioteca/Login")
public class LoginBibliotecaServlet extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginBibliotecaServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("./login.jsp");
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = DatabaseManagerBiblioteca.login(email, password);
		if (utente != null) {
			request.getSession().setAttribute("utenteAttivo", utente);
			if (utente.isAdmin()) {
				response.sendRedirect("./AdminDashboard.jsp");
			} else {
				response.sendRedirect("./Prestiti");
			}
		} else {
			request.getSession().setAttribute("errore", "Credenziali errate.");
			response.sendRedirect("./login.jsp");
		}
	}

}
