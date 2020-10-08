package it.beije.oort.web.girardi.biblioteca;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class navigaSv
 */
@WebServlet("/NavigaSv")
public class NavigaSv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String richiesta = request.getParameter("naviga");
		switch (richiesta) { 
		case "catalogo":
//			response.sendRedirect("biblioteca/catalogo.jsp");
			response.sendRedirect("biblioteca/workInProgress.jsp");
			break;
		case "campi": 
//			response.sendRedirect("biblioteca/campi.jsp");
			response.sendRedirect("biblioteca/workInProgress.jsp");

			break;
		case "id": 
			response.sendRedirect("biblioteca/id.jsp");
			break;
		default:
			response.sendRedirect("biblioteca/naviga.jsp");
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
