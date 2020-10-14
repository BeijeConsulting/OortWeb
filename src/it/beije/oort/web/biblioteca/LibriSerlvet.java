package it.beije.oort.web.biblioteca;

import java.io.IOException;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/libri")
public class LibriSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		String jpql = "SELECT l FROM Libri as l";
		Query query = entityManager.createQuery(jpql);
		List<Libri> libri = query.getResultList();
		if(libri.size()!= 0){
		request.getSession().setAttribute("userBean2", libri);
		response.sendRedirect("libri.jsp");
		
		}else{
		request.getSession().setAttribute("errore", "Nessun libro presente!");
		response.sendRedirect("conferma.jsp");
		}
		
	}

}