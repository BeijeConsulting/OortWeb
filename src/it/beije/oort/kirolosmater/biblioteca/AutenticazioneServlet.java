package it.beije.oort.kirolosmater.biblioteca;

import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = checkEmail(email);
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			request.getSession().setAttribute("userBean", utente);
			response.sendRedirect("areaPersonale.jsp");
		} else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("loginUtente.jsp");
		}
	}
	
	public static Utente checkEmail (String email) {
		Utente utente = new Utente();
		List<Utente> utenti = readRecordByStringFromInput("email", email);
		utente = utenti.get(0);
		return utente;
	}
	
	public static boolean checkPassword (Utente utente, String password) {
		boolean passwordCorretta = false;
		passwordCorretta = password.equals(utente.getPassword());
		return passwordCorretta;
	}

}
