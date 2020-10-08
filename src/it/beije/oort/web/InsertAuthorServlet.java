package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.db.JPDBUtilities;

/**
 * Servlet implementation class InsertAuthorServlet
 */
@WebServlet("/InsertAuthorServlet")
public class InsertAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("form_autore.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = (String)request.getParameter("nome");
		String cognome = (String)request.getParameter("cognome");
		String data_nascita = (String)request.getParameter("data_nascita");
		String data_morte = (String)request.getParameter("data_morte");
		String biografia = (String)request.getParameter("biografia");
		JPDBUtilities.insertAuthor(cognome, nome, data_nascita, data_morte, biografia);
		response.sendRedirect("registra_libro.jsp");
	}
}
