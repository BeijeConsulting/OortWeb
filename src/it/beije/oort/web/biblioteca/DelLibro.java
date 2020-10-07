package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.web.biblioteca.SingletonJPABiblio;


@WebServlet("/delLibro")
public class DelLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		StringBuilder builder = new StringBuilder("<h3>Contatto cancellato correttamente!</h3> <br>");
		String id_value = request.getParameter("id");
				
				
		if (id_value != null){		
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		String jpql = ("SELECT l FROM Libri as l WHERE id = " + id_value) ;
		Query query = entityManager.createQuery(jpql);
			entityManager.remove(query.getResultList().get(0));
		entityManager.getTransaction().commit();
		entityManager.close();	
		System.out.println("Cancellato!");
					
		response.getWriter().append(builder);
		}
		else { 
			System.out.println("sei qui!");
		}
					
		StringBuilder b = new StringBuilder("<br><!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"	<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"menu.html\" method=\"POST\">\r\n" + 
				"			<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
				"		</form>		\r\n" + 
				"	</body>\r\n" + 
				"</html>");
		response.getWriter().append(b);
				
	}
}
	

