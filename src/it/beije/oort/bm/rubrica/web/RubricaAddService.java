package it.beije.oort.bm.rubrica.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.oort.bm.rubrica.Contatto;
import it.beije.oort.bm.rubrica.database.Database;
import it.beije.oort.bm.rubrica.database.JPADatabase;


@WebServlet("/addService")
public class RubricaAddService extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	private static Database db = JPADatabase.getDatabase();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("bm_index.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contatto c = new Contatto();
		c.setNome(req.getParameter("fname"));
		c.setCognome(req.getParameter("lname"));
		c.setTelefono(req.getParameter("phone"));
		c.setEmail(req.getParameter("email"));
		db.insert(c);
		req.getSession().removeAttribute("results");
		resp.sendRedirect("bm_index.jsp");
	}
	
}
