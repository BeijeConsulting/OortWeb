package it.beije.oort.web.girardi.biblioteca;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomepageSv
 */
@WebServlet("/HomepageSv")
public class HomepageSv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String richiesta = request.getParameter("homepage");
		switch (richiesta) { 
		case "operazioni":
			response.sendRedirect("biblioteca/operazioni.jsp");
			break;
		case "naviga": 
			response.sendRedirect("biblioteca/naviga.jsp");
			break;
		default:
			response.sendRedirect("biblioteca/homepage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
