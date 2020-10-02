package it.beije.oort.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Show")
public class VisualizzaContattiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		visualizza(response);
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
	
	public static List<Contatto> visualizza(HttpServletResponse response) throws IOException {
		StringBuilder builder = new StringBuilder("<h1>Lista contatti in rubrica:</h1>");
		EntityManager entityManager = SingletonJPA.openEntity();
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> contatti = query.getResultList();
		for (Contatto contatto : contatti) {
			builder.append("[ID: ").append(contatto.getId()).append(" - NOME : ").append(contatto.getNome())
			.append(" - COGNOME : ").append(contatto.getCognome())
			.append(" - TELEFONO : ").append(contatto.getTelefono()).append(" - EMAIL : ").append(contatto.getEmail())
			.append("]").append("<br>");
		}	
		response.getWriter().append(builder);
			
		
		entityManager.close();
		return contatti;
		
	} 

}
