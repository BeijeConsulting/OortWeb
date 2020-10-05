package it.beije.oort.web.girardi.rubrica;
// http://localhost:8080/OortWeb/rubrica/menu.html

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.girardi.jpa.JPAfactory;
import it.beije.oort.web.girardi.jpa.RubricaJPA;

/**
 * Servlet implementation class VisualizzaTutttiServlet
 */
@WebServlet("/VisualizzaIdServlet")
public class VisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro = request.getParameter("id");
		if (parametro == null)
			response.getWriter().append("Non hai effettuato alcuna selezione");
		else {
			try {
			int id = Integer.parseInt(request.getParameter("id"));			
			//apro EntityManagerFactory
			EntityManager entityManager = JPAfactory.openEntityFactory();
			//SELECT
			request.getParameter("id");
			Contatto contatto = entityManager.find(Contatto.class, id);
			StringBuilder strb = new StringBuilder().append(contatto);
			response.getWriter().append(strb);
			} catch (NumberFormatException nfe) {
				response.getWriter().append("Non hai inserito un numero");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
