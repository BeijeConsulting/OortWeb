package it.beije.oort.madonia.biblioteca.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;

/**
 * Servlet implementation class ModificaAutoreServlet
 */
@WebServlet("/biblioteca/ModificaAutore")
public class ModificaAutoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAutoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utenteAttivo = (Utente) request.getSession().getAttribute("utenteAttivo");
    	if (utenteAttivo == null || utenteAttivo.getId() == 0) {
    		request.getSession().setAttribute("errore", "Devi effettuare il login prima di accedere ai contenuti.");
    		response.sendRedirect("./login.jsp");
    	} else if (! utenteAttivo.isAdmin()) {
    		request.getSession().setAttribute("errore", "Non hai i permessi per visualizzare questi contenuti");
    		response.sendRedirect("./login.jsp");
    	} else {
    		response.sendRedirect("./ModificaAutore.jsp");
    	}
	}

}
