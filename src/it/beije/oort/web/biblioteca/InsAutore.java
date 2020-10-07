package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insautore")
public class InsAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> ");
	String nome = request.getParameter("nome");
	String cognome = request.getParameter("cognome");
	String datan =  request.getParameter("data_n");
	String datam = request.getParameter("data_m");
	String bio = request.getParameter("bio");
	
	EntityManager entityManager = SingletonJPABiblio.openEntity();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	Autore autore = new Autore();

	
	autore.setNome(nome);
	autore.setCognome(cognome);
	autore.setDataNascita(datan);
	autore.setDataMorte(datam);
	autore.setBiografia(bio);
	entityManager.persist(autore);
	entityManager.getTransaction().commit();
	entityManager.close();
	System.out.println("Contatto inserito correttamente!");
	
		
	builder.append("<br>NOME : ").append(nome).append("<br>COGNOME : ").append(cognome)
	.append("<br>DATA NASCITA : ").append(datan).append("<br>DATA MORTE : ").append(datam).append("<br>BIOGRAFIA: ").append(bio);

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
