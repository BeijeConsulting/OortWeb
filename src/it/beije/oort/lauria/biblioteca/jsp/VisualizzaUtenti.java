package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Utente;

/**
 * Servlet implementation class VisualizzaUtenti
 */
@WebServlet("/VisualizzaUtenti")
public class VisualizzaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utente> utenti = JPADBtools.selectUtenti();
		request.getSession().setAttribute("catalogoUtenti", utenti);
		response.sendRedirect("visualizzaUtenti.jsp");
	}

}
