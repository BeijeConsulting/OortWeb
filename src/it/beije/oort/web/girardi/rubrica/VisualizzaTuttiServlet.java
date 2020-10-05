package it.beije.oort.web.girardi.rubrica;

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

/**
 * Servlet implementation class VisualizzaTuttiServlet
 */
@WebServlet("/VisualizzaTuttiServlet")
public class VisualizzaTuttiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//apro EntityManagerFactory
		EntityManager entityManager = JPAfactory.openEntityFactory();

		//query JPQL
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		StringBuilder strb = new StringBuilder("totale contatti: ");
		strb.append(contatti.size());
		for (Contatto contatto : contatti) {
			strb.append("\n").append(contatto);
		}
		response.getWriter().append(strb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
