package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.db.JPDBUtilities;

/**
 * Servlet implementation class IscrizioneServlet
 */
@WebServlet("/IscrizioneServlet")
public class IscrizioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IscrizioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("form_iscrizione.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cognome = (String) request.getParameter("cognome");
		String nome = (String) request.getParameter("nome");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		JPDBUtilities.insertUser(nome, cognome, null, email, null, null, password);
		response.sendRedirect("login_biblioteca.jsp");
	}
}
