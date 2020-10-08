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

@WebServlet("/utenti")
public class UtentiSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EntityManager entityManager = SingletonJPABiblio.openEntity();
	String jpql = "SELECT u FROM Utenti as u";
	Query query = entityManager.createQuery(jpql);
	List<Utenti> utenti = query.getResultList();
	if(utenti.size()!= 0){
	request.getSession().setAttribute("userBean6", utenti);
	response.sendRedirect("utenti.jsp");
	
	}else{
	request.getSession().setAttribute("errore", "Nessun editore presente!");
	response.sendRedirect("conferma.jsp");
	}

	}

}
