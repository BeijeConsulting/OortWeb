package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Smistatore
 */
@WebServlet("/Smistatore")
public class Smistatore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Smistatore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Catalogo")!=null) {
			request.getSession().setAttribute("richiestaCatalogo", "on");
			response.sendRedirect("./Catalogo");
		}
		if(request.getParameter("Prestiti")!=null) {
			response.sendRedirect("visualizzaprestiti.jsp");
		}
		if(request.getParameter("Menu")!=null) {
			response.sendRedirect("menubiblioteca.jsp");
		}
		if(request.getParameter("Login")!=null) {
			response.sendRedirect("login.jsp");
		}
		if(request.getParameter("NewPrestito")!=null) {
			response.sendRedirect("newprestito.jsp");
		}
		if(request.getParameter("CatalogoUtenti")!=null) {
			response.sendRedirect("utenti.jsp");
		}
		if(request.getParameter("CatalogoEditori")!=null) {
			response.sendRedirect("editori.jsp");
		}
		if(request.getParameter("CatalogoAutori")!=null) {
			response.sendRedirect("autori.jsp");
		}
		if(request.getParameter("NewAutore")!=null) {
			response.sendRedirect("newautore.jsp");
		}
		if(request.getParameter("NewEditore")!=null) {
			response.sendRedirect("neweditore.jsp");
		}
		if(request.getParameter("NewUtente")!=null) {
			response.sendRedirect("newutente.jsp");
		}
	}



}
