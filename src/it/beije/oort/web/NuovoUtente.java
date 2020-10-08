package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class NuovoUtente
 */
@WebServlet("/NuovoUtente")
public class NuovoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
				Utenti utente = new Utenti();
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String telefono = request.getParameter("telefono");
				String codice_fisc = request.getParameter("codice_fisc");
				String indirizzo = request.getParameter("indirizzo");
				int admin;
				try{
					admin = Integer.parseInt(request.getParameter("admin"));
				} catch(NumberFormatException e) {
					admin = 0;
				}
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setEmail(email);
				utente.setPassword(password);
				utente.setTelefono(telefono);
				utente.setCodice_fiscale(codice_fisc);
				utente.setIndirizzo(indirizzo);
				if(admin!=1) utente.setAdmin(false);
				else utente.setAdmin(true);
				request.getSession().setAttribute("errore", "Utente Inserito Correttamente");
				JPDBtools.insert(utente, "OortBiblioteca");
				response.sendRedirect("menubiblioteca.jsp");
			} catch(Exception e) {
				request.getSession().setAttribute("errore", "Errore Inserito Utente");
				response.sendRedirect("menubiblioteca.jsp");
			}
	}

}
