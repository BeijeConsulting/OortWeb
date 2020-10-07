package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/inseditore")
public class InsEditore extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> ");
		String nome = request.getParameter("denominazione");
		String descr = request.getParameter("descrizione");
		
		
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Editori editore = new Editori();

		
		editore.setDenominazione(nome);
		editore.setDescrizione(descr);
		
		entityManager.persist(editore);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente!");
		
			
		builder.append("<br>NOME : ").append(nome).append("<br>DESCRIZIONE : ").append(descr);

		response.getWriter().append(builder).append("<br>");
		
		StringBuilder b = new StringBuilder("<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"	<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"conferma.jsp\" method=\"POST\">\r\n" + 
				"		<br><button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
				"		</form>		\r\n" + 
				"	</body>\r\n" + 
				"</html>");
		response.getWriter().append(b);
	}

}
