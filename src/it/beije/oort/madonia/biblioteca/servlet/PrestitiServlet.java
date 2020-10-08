package it.beije.oort.madonia.biblioteca.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

/**
 * Servlet implementation class PrestitiServlet
 */
@WebServlet("/biblioteca/Prestiti")
public class PrestitiServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrestitiServlet() {
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
    	} else {
    		List<Prestito> listaPrestiti = DatabaseManagerBiblioteca.trovaPrestiti(utenteAttivo);
    		Map<Integer, String> mappaTitoli = new HashMap<Integer, String>();

    		for(Prestito prestito : listaPrestiti) {
    			if ( mappaTitoli.containsKey(prestito.getIdLibro()) || prestito.getIdLibro() == 0 ) { continue; }

    			Libro libro = DatabaseManagerBiblioteca.trovaLibro(prestito.getIdLibro());
    			if (libro != null) {
    				mappaTitoli.put(prestito.getIdLibro(), libro.getTitolo());
    			}
    		}
    		
    		request.getSession().setAttribute("listaPrestiti", listaPrestiti);
    		request.getSession().setAttribute("mappaTitoli", mappaTitoli);
    		response.sendRedirect("./Prestiti.jsp");
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
