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


@WebServlet("/autori")
public class AutoriSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EntityManager entityManager = SingletonJPABiblio.openEntity();
	String jpql = "SELECT a FROM Autore as a";
	Query query = entityManager.createQuery(jpql);
	List<Autore> autori = query.getResultList();
	if(autori.size()!= 0){
	request.getSession().setAttribute("userBean4", autori);
	response.sendRedirect("autori.jsp");
	
	}else{
	request.getSession().setAttribute("errore", "Nessun editore presente!");
	response.sendRedirect("conferma.jsp");
	}

	}
}
