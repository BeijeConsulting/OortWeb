package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.biblioteca.JPADBtools;

/**
 * Servlet implementation class VisualizzaEditori
 */
@WebServlet("/VisualizzaEditori")
public class VisualizzaEditori extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaEditori() {
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
		List<Editore> editori = JPADBtools.selectEditori();
		request.getSession().setAttribute("catalogoEditori", editori);
		response.sendRedirect("visualizzaEditori.jsp");
	}

}
