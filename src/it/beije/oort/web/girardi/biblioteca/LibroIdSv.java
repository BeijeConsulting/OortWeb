package it.beije.oort.web.girardi.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.girardi.jpa.JPAfactory;
import it.beije.oort.web.girardi.rubrica.Contatto;

/**
 * Servlet implementation class LibroIdSv
 */
@WebServlet("/LibroIdSv")
public class LibroIdSv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if (request.getParameter("id").equals("")) {
			request.getSession().setAttribute("errore", "NON HAI INSERITO ALCUN ID");
			response.sendRedirect("biblioteca/id.jsp");
		} else {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				request.getSession().setAttribute("intId", id);
			} catch (NumberFormatException nfe) {
				request.getSession().setAttribute("errore", "L'ID INSERITO NON E' VALIDO");
			} finally {
			response.sendRedirect("biblioteca/id.jsp");
			}
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
