package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.biblioteca.Prestito;
import it.beije.oort.lauria.biblioteca.Utente;

/**
 * Servlet implementation class VisualizzaPrestiti
 */
@WebServlet("/VisualizzaPrestiti")
public class VisualizzaPrestiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaPrestiti() {
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
		List<Prestito> prestiti = JPADBtools.selectPrestiti();
		request.getSession().setAttribute("catalogoPrestiti", prestiti);
		List<Libro> libri = JPADBtools.selectLibri();
		request.getSession().setAttribute("catalogoLibri", libri);
		List<Utente> utenti = JPADBtools.selectUtenti();
		request.getSession().setAttribute("catalogoUtenti", utenti);
		response.sendRedirect("visualizzaPrestiti.jsp");
	}

}
