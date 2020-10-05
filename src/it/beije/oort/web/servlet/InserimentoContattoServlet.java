package it.beije.oort.web.servlet;

import java.io.IOException;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/InsertC")
public class InserimentoContattoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> <br>");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		EntityManager entityManager = SingletonJPA.openEntity();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Contatto contatto = new Contatto();

		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setTelefono(telefono);
		contatto.setEmail(email);
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("Contatto inserito correttamente!");
		
			
		builder.append("<br/>NOME : ").append(nome).append("<br/>COGNOME : ").append(cognome)
		.append("<br/>TELEFONO : ").append(telefono).append("<br/>EMAIL : ").append(email);

		response.getWriter().append(builder).append("<br>");
		
		StringBuilder b = new StringBuilder("<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"	<title></title>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"menu.html\" method=\"POST\">\r\n" + 
				"		<button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
				"		</form>		\r\n" + 
				"	</body>\r\n" + 
				"</html>");
		response.getWriter().append(b);
	}
	
}
