package it.beije.oort.web.biblioteca;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditoriSerlvet
 */
@WebServlet("/editori")
public class EditoriSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		String jpql = "SELECT e FROM Editori as e";
		Query query = entityManager.createQuery(jpql);
		List<Editori> editori = query.getResultList();
		if(editori.size()!= 0){
		request.getSession().setAttribute("userBean3", editori);
		response.sendRedirect("editori.jsp");
		
		}else{
		request.getSession().setAttribute("errore", "Nessun editore presente!");
		response.sendRedirect("conferma.jsp");
		}
	}

	
}
