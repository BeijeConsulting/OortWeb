package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GestioneLink
 */
@WebServlet("/GestioneLink")
public class GestioneLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneLink() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String page = (String)request.getParameter("page");
		if(page != null) {
			if(page.equals("home")) {
				response.sendRedirect("./biblioteca/home.html");
			}
			else if(page.equals("inserimento")) {
				response.sendRedirect("./biblioteca/inserimento.html");
			}
			else if(page.equals("visualizzazione")) {
				response.sendRedirect("./biblioteca/visualizzazione.jsp");
			}
			else if(page.equals("modifica")) {
				response.sendRedirect("./biblioteca/modifica.html");
			}
			else if(page.equals("rimozione")) {
				response.sendRedirect("./biblioteca/eliminazione.jsp");
			}		
			else if(page.equals("ricerca")) {
				response.sendRedirect("./biblioteca/ricerca.html");
			}		
			else if(page.equals("esportazione")) {
				response.sendRedirect("./biblioteca/esportazione.html");
			}		
			else if(page.equals("registrazione")) {
				response.sendRedirect("./biblioteca/login/registrazione.jsp");
			}		
			else if(page.equals("login")) {
				response.sendRedirect("./biblioteca/login/login.jsp");
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
