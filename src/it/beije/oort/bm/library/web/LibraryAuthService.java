package it.beije.oort.bm.library.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.bm.library.User;
import it.beije.oort.bm.library.database.*;
import java.util.List;

@WebServlet("/loginService")
public class LibraryAuthService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database db = ConcreteDatabase.getDatabase();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User u = new User();
		u.setPassword(password);
		u.setEmail(email);
		HttpSession session = req.getSession();
		List<User> result = db.searchRecord(User.class, u);
		if(result.size() != 1) {
			session.setAttribute("tmpEmail", email);
			session.setAttribute("loginError", "Credenziali errate, riprova.");
		}else {
			session.removeAttribute("tmpEmail");
			session.setAttribute("user", result.get(0));
		}
		resp.sendRedirect("library_index.jsp");
		
	}

	

}
