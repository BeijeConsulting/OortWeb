package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.readRecordFromDb;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Utente;

/**
 * Servlet implementation class BibliotecaUtenteVisualizzaIdServlet
 */
@WebServlet("/biblioteca/view/BibliotecaUtenteVisualizzaIdServlet")
public class BibliotecaUtenteVisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaUtenteVisualizzaIdServlet() {
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
		Utente utente = readRecordFromDb(id);
		String nome = utente.getNome();
		String cognome = utente.getCognome();
		String codice_fiscale = utente.getCodice_fiscale();
		String email = utente.getEmail();
		String telefono = utente.getTelefono();
		String indirizzo = utente.getIndirizzo();
		boolean admin = utente.isAdmin();
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		session.setAttribute("codice_fiscale", codice_fiscale);
		session.setAttribute("email", email);
		session.setAttribute("telefono", telefono);
		session.setAttribute("indirizzo", indirizzo);
		session.setAttribute("admin", admin);
		response.sendRedirect("visualizzaUtenteId.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
