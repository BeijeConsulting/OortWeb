package it.beije.oort.bm.library.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.beije.oort.bm.library.*;
import it.beije.oort.bm.library.database.*;

@WebServlet("/dispatch")
public class LibraryDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Database db = ConcreteDatabase.getDatabase();
	
	@SuppressWarnings("rawtypes")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("res");
		List list = null;
		switch(param) {
			case "books":
				list = db.getAll(Book.class);
				break;
			case "authors":
				list = db.getAll(Author.class);
				break;
			case "publish":
				list = db.getAll(Publisher.class);
				break;
			case "loans":
				list = db.getAll(Loan.class);
				break;
			case "users":
				list = db.getAll(User.class);
				break;
		}
		req.getSession().setAttribute("status", param);
		req.getSession().setAttribute("data_list", list);
		resp.sendRedirect("library_index.jsp");
	}

}
