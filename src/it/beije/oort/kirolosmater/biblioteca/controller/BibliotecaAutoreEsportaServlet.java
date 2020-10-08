package it.beije.oort.kirolosmater.biblioteca.controller;
import static it.beije.oort.kirolosmater.biblioteca.MetodiAutore.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Autore;

/**
 * Servlet implementation class BibliotecaAutoreEsportaServlet
 */
@WebServlet("/biblioteca/view/BibliotecaAutoreEsportaServlet")
public class BibliotecaAutoreEsportaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaAutoreEsportaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String path = request.getParameter("path");
		int id_iniziale = Integer.parseInt(request.getParameter("id_iniziale"));
		int id_finale = Integer.parseInt(request.getParameter("id_finale"));
		List<Autore> autori = readRecords(id_iniziale, id_finale);
		exportListToCsv(autori, path);
		response.sendRedirect("esportaAutore.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
