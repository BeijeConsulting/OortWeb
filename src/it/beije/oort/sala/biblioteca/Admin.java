package it.beije.oort.sala.biblioteca;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String req = request.getParameter("req");
		System.out.println(req);
		if(req!=null) {
			switch(req) {
			case "homeadmin":
				response.sendRedirect("/OortWeb/sala/biblioteca/admin.html");
				break;
			case "prestiti":
				response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/prestiti.html");
				break;
			case "libri":
				response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/libri.html");
				break;
			case "editori":
				response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/editori.html");
				break;
			case "autori":
				response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/autori.html");
				break;
			case "utenti":
				response.sendRedirect("/OortWeb/sala/biblioteca/sub-admin/utenti.html");
				break;		
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
