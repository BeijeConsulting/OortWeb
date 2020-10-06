package it.beije.oort.web.biblioteca;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/authSerlvet")
public class AuthSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		EntityManager entityManager = SingletonJPABiblio.openEntity();
		String jpql = ("SELECT u FROM Utenti as u WHERE email = '" + email + "' and password = '" + password + "'") ;
		Query query = entityManager.createQuery(jpql);
		List<Utenti> utenti = query.getResultList();
		System.out.println("Lista utenti: " + utenti.size());
		
		if(utenti.size() == 1){
			Utenti utente = new Utenti();
			utente = utenti.get(0);
			System.out.println(utente);
			request.getSession().setAttribute("userBean", utente);
			response.sendRedirect("conferma.jsp");
			System.out.println("YES");			
		}else {
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			response.sendRedirect("login.jsp");
			System.out.println("NO");
		}
			

}}
