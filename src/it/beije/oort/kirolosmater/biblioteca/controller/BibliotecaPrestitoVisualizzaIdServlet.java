package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiPrestito.readRecordFromDb;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Prestito;

/**
 * Servlet implementation class BibliotecaPresitoVisualizzaIdServlet
 */
@WebServlet("/biblioteca/view/BibliotecaPrestitoVisualizzaIdServlet")
public class BibliotecaPrestitoVisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaPrestitoVisualizzaIdServlet() {
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
		Prestito prestito = readRecordFromDb(id);
		String libro = prestito.getLibro();
		String utente = prestito.getUtente();
		LocalDate data_inizio = prestito.getData_inizio();
		LocalDate data_fine = prestito.getData_fine();
		String note = prestito.getNote();
		session.setAttribute("libro", libro);
		session.setAttribute("utente", utente);
		session.setAttribute("data_inizio", data_inizio);
		session.setAttribute("data_fine", data_fine);
		session.setAttribute("note", note);
		response.sendRedirect("visualizzaPrestitoId.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
