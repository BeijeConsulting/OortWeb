package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.biblioteca.Editori;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class NuovoEditore
 */
@WebServlet("/NuovoEditore")
public class NuovoEditore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoEditore() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String denominazione = request.getParameter("denominazione");
				String descrizione = request.getParameter("descrizione");
				Editori editore = new Editori();
				editore.setDenominazione(denominazione);
				editore.setDescrizione(descrizione);
				JPDBtools.insert(editore, "OortBiblioteca");
				request.getSession().setAttribute("errore", "Editore Inserito Correttamente");
				response.sendRedirect("menubiblioteca.jsp");
			} catch(Exception e) {
				request.getSession().setAttribute("errore", "Valori Editore Errati");
				response.sendRedirect("menubiblioteca.jsp");
			}
			
	}

}
