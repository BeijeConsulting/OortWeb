package it.beije.oort.sala.biblioteca;

import it.beije.oort.sala.biblioteca.beans.Databasable;
import it.beije.oort.sala.biblioteca.beans.Utente;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.sala.web.db.JPAToolset;

/**
 * Servlet implementation class Biblioteca
 */
@WebServlet
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	if(request.getParameter("logout")!=null && request.getParameter("logout").equals("true")) {
    		HttpSession session = request.getSession();
    		session.invalidate();
    	}
    	response.sendRedirect("/OortWeb/sala/biblioteca/index.jsp");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Utente u = checkLogin(email, password);
		if(u!=null) {
			session.setAttribute("nome", u.getNome());
			session.setAttribute("admin", u.isAdmin());
			session.setAttribute("userid", u.getId_utente());
			session.setAttribute("auth", true);
			response.sendRedirect("/OortWeb/sala/biblioteca/user.jsp");
		} else {
			session.setAttribute("auth", false);
			session.setAttribute("error", "ERRORE: Email o password errati");
			response.sendRedirect("/OortWeb/sala/biblioteca/index.jsp");
		}
	}

	private Utente checkLogin(String email, String password) {
		List<Object> temp = JPAToolset.selectJPA(email, password);
		if(temp.size()==1) {
			return (Utente)temp.get(0);
		}
		return null;
	}
}
