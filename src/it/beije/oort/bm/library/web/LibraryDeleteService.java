package it.beije.oort.bm.library.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.bm.library.Book;
import it.beije.oort.bm.library.database.ConcreteDatabase;
import it.beije.oort.bm.library.database.Database;

@WebServlet("/deleteService")
public class LibraryDeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database db = ConcreteDatabase.getDatabase();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("del_id"));
		db.remove(Book.class, id);
		resp.sendRedirect("./dispatch?res=books");
	}

}
