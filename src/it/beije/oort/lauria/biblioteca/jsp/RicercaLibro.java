package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.JEntityManagerFactory;
import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.rubrica.Contatto;
import it.beije.oort.lauria.rubrica.JPADBtoolsRubrica;

/**
 * Servlet implementation class RicercaLibro
 */
@WebServlet("/RicercaLibro")
public class RicercaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaLibro() {
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
		String id_libro = (String) request.getParameter("id_libro");
		Libro libro = JPADBtools.entityManager.find(Libro.class, Integer.parseInt(id_libro));
		request.getSession().setAttribute("ricercaLibro", libro);
		response.sendRedirect("ricercaLibro.jsp");
	}

}
