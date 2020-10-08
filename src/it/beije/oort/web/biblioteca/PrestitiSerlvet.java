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

@WebServlet("/prestiti")
public class PrestitiSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		String jpql = "SELECT p FROM Prestiti as p";
		Query query = entityManager.createQuery(jpql);
		List<Prestiti> prestito = query.getResultList();
		if(prestito.size()!= 0){
		request.getSession().setAttribute("userBean5", prestito);
		response.sendRedirect("prestiti.jsp");
		
		}else{
		request.getSession().setAttribute("errore", "Nessun prestito presente!");
		response.sendRedirect("conferma.jsp");
		}
		
	}

}

