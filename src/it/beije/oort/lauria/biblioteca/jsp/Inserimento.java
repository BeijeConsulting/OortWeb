package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.BiblioClient;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Inserimento")
public class Inserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserimento() {
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
		String page = (String) request.getParameter("page");
//		if(page != null) {
			switch(page) {
			case "libro":
				response.sendRedirect("registraLibro.jsp");
				break;
			case "autore":
				response.sendRedirect("registraAutore.jsp");
				break;
			case "editore":
				response.sendRedirect("registraEditore.jsp");
				break;
			case "utente":
				response.sendRedirect("registraUtente.jsp");
				break;
			case "prestito":
				response.sendRedirect("registraPrestito.jsp");
				break;
			}
		}
//	}

}
