package it.beije.oort.bm.rubrica.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.oort.bm.rubrica.database.Database;
import it.beije.oort.bm.rubrica.database.JPADatabase;


@WebServlet("/updateService")
public class RubricaUpdateService extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	private static Database db = JPADatabase.getDatabase();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("bm_index.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String[] vals = new String[4];
		boolean[] selector = new boolean[4];
		vals[0] = req.getParameter("lname");
		if(vals[0] == null || vals[0].equals("")) {
			selector[0] = false;
		}else {
			selector[0] = true;
		}
		vals[1] = req.getParameter("fname");
		if(vals[1] == null || vals[1].equals("")) {
			selector[1] = false;
		}else {
			selector[1] = true;
		}
		vals[2] = req.getParameter("phone");
		if(vals[2] == null || vals[2].equals("")) {
			selector[2] = false;
		}else {
			selector[2] = true;
		}
		vals[3] = req.getParameter("email");
		if(vals[3] == null || vals[3].equals("")) {
			selector[3] = false;
		}else {
			selector[3] = true;
		}
		db.update(id, selector, vals);
		req.getSession().removeAttribute("results");
		resp.sendRedirect("bm_index.jsp");
	}
	
}
