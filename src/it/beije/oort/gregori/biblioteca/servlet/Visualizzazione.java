package it.beije.oort.gregori.biblioteca.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.gregori.biblioteca.jpa.Autore;
import it.beije.oort.gregori.biblioteca.jpa.AutoreUtility;
import it.beije.oort.gregori.biblioteca.jpa.Utente;
import it.beije.oort.gregori.biblioteca.jpa.UtenteUtility;

/**
 * Servlet implementation class Visualizzazione
 */
@WebServlet("/Visualizzazione")
public class Visualizzazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visualizzazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String tabella = request.getParameter("selezione-tabella");
		HttpSession session = request.getSession();
		
		session.setAttribute("tabella", tabella);
		
		switch(tabella) {
		
			case "utente":
				List<Utente> utenti = UtenteUtility.visualizza();
				session.setAttribute("utenti", utenti);
			break;
			
			case "autore":
				List<Autore> autori = AutoreUtility.visualizza();
				session.setAttribute("autori", autori);
				break;
		
		}
		response.sendRedirect("./biblioteca/visualizzazione.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
