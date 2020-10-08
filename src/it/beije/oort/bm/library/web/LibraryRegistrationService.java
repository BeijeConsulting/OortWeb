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

@WebServlet("/registerService")
public class LibraryRegistrationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database db = ConcreteDatabase.getDatabase();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String pswd = req.getParameter("reg_pswd");
		String pswd_conf = req.getParameter("reg_pswd_conf");
		if(!pswd.equals(pswd_conf)) {
			session.setAttribute("regError", "Given passwords are not equals.");
		}else {
			User reg = new User();
			reg.setName(req.getParameter("reg_name"));
			reg.setSurname(req.getParameter("reg_surname"));
			reg.setFc(req.getParameter("reg_fc"));
			reg.setAddress(req.getParameter("reg_addr"));
			reg.setPhone(req.getParameter("reg_phone"));
			reg.setEmail(req.getParameter("reg_email"));
			reg.setPassword(pswd);
			reg.setAdmin(false);
			boolean ok = db.add(reg);
			if(!ok) {
				session.setAttribute("regError", "E-mail already in use.");
			}else {
				resp.sendRedirect("./dispatch?res=login");
				return;
			}
		}
		resp.sendRedirect("library_index.jsp");
		
	}

	

}
