package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.web.db.JPDBUtilities;
import it.beije.oort.web.db.User;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/authservlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (JPDBUtilities.checkLogin(email, password)) {
			User user = JPDBUtilities.exportLoggedUser(email, password);
			session.setAttribute("loggedUser", user);
			if (user.isAdmin()) {
				response.sendRedirect("admin_biblio_homepage.jsp");
			} else {
				response.sendRedirect("user_biblio_homepage.jsp");
			}
		} else {
			request.getSession().setAttribute("errore", "Credenziali errate");
			response.sendRedirect("login_biblioteca.jsp");
		}
	}
}
