package it.beije.oort.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class Catalogo
 */
@WebServlet("/Catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Catalogo() {
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
		HttpSession session = request.getSession();
		String autore = request.getParameter("Autore");
		String editore = request.getParameter("Editore");
		List<Libri> catalogo;
		//controllo se è la prima chiamata o ha già i valori autore ed editore
		if (autore!=null && editore!=null || ((String)session.getAttribute("richiestaCatalogo")).equals("on")) {
			if(autore==null && editore==null) {
				response.sendRedirect("catalogo.jsp");
			}
			else {
				if(autore.equals(editore) && autore.equals("0")){ 			
				catalogo = JPDBtools.catalogoLibri();
				} else { 
				catalogo = JPDBtools.catalogoLibriPersonalizzato(Integer.parseInt(autore), Integer.parseInt(editore));
				}
				session.setAttribute("richiestaCatalogo", "off");
				session.setAttribute("catalogo", catalogo);
				response.sendRedirect("catalogo.jsp");
			}
		}
	}

}
