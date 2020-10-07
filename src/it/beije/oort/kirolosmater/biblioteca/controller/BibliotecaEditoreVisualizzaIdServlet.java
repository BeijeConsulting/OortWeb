package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiEditore.*;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Editore;

/**
 * Servlet implementation class BibliotecaEditoreVisualizzaIdServlet
 */
@WebServlet("/biblioteca/view/BibliotecaEditoreVisualizzaIdServlet")
public class BibliotecaEditoreVisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaEditoreVisualizzaIdServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Editore editore = readRecordFromDb(id);
		String denominazione = editore.getDenominazione();
		String descrizione = editore.getDescrizione();

		session.setAttribute("denominazione", denominazione);
		session.setAttribute("descrizione", descrizione);
		response.sendRedirect("visualizzaEditoreId.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}