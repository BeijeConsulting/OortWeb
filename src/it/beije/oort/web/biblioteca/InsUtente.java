package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insUtente")
public class InsUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> ");
	String nome = request.getParameter("nome");
	String cognome = request.getParameter("cognome");
	String cf =  request.getParameter("codice_fiscale");
	String ind = request.getParameter("indirizzo");
	String email = request.getParameter("email");
	String telefono = request.getParameter("telefono");
	String password = request.getParameter("password");
		
	EntityManager entityManager = SingletonJPABiblio.openEntity();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	Utenti utente = new Utenti();

	
	utente.setNome(nome);;
	utente.setCognome(cognome);
	utente.setCodiceFiscale(cf);
	utente.setIndirizzo(ind);
	utente.setEmail(email);
	utente.setTelefono(telefono);
	utente.setPassword(password);
	entityManager.persist(utente);
	entityManager.getTransaction().commit();
	entityManager.close();
	System.out.println("Utente inserito correttamente!");
	
		
	builder.append("<br>NOME: ").append(nome).append("<br>COGNOME: ").append(cognome)
	.append("<br>CODICE F. : ").append(cf).append("<br>INDIRIZZO: ").append(ind).append("<br>EMAIL: ").append(email)
	.append("<br>TELEFONO: ").append(telefono).append("<br>PASSWORD: ******");

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
