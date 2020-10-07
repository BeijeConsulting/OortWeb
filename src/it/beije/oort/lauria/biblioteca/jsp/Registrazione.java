package it.beije.oort.lauria.biblioteca.jsp;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.lauria.biblioteca.BiblioClient;
import it.beije.oort.lauria.biblioteca.JPADBtools;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = (String) request.getParameter("page");
		
		if(page != null) {
			switch(page) {
			case "libro":{
				String titolo = request.getParameter("titolo");
				String descrizione = request.getParameter("descrizione");
				String id_autore = request.getParameter("id_autore");
				String id_editore = request.getParameter("id_editore");
				String anno = request.getParameter("anno");
				
				JPADBtools.insertLibro(titolo, descrizione, Integer.parseInt(id_autore), Integer.parseInt(id_editore), anno);

				request.getSession().setAttribute("nuovoLibro", "TRUE");	
				
				response.sendRedirect("registraLibro.jsp");
				
				break;
			}
			case "autore":{
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String data_nascita = request.getParameter("data_nascita");
				String data_morte = request.getParameter("data_morte");
				String biografia = request.getParameter("biografia");
				
				DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
				LocalDate data_n = LocalDate.parse(data_nascita, f);
				LocalDate data_m = LocalDate.parse(data_morte, f);
				
				JPADBtools.insertAutore(nome, cognome, data_n, data_m, biografia);

				request.getSession().setAttribute("nuovoAutore", "TRUE");	
				
				response.sendRedirect("registraAutore.jsp");
				break;
			}
			case "editore":{
				String denominazione = request.getParameter("denominazione");
				String descrizione = request.getParameter("descrizione");
				
				JPADBtools.insertEditore(denominazione, descrizione);

				request.getSession().setAttribute("nuovoEditore", "TRUE");	
				
				response.sendRedirect("registraEditore.jsp");
				break;
			}
			case "utente":{
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String codice_fiscale = request.getParameter("codice_fiscale");
				String telefono = request.getParameter("telefono");
				String indirizzo = request.getParameter("indirizzo");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String admin = request.getParameter("password");
				
				boolean adminUtente = false;
				
				if(admin.equals("1")) {
					adminUtente = true;
				}
				JPADBtools.insertUtente(nome, cognome, codice_fiscale, email, telefono, indirizzo, password, adminUtente);

				request.getSession().setAttribute("nuovoUtente", "TRUE");	
				
				response.sendRedirect("registraUtente.jsp");
				break;
			}
			case "prestito":{
				String id_libro = request.getParameter("id_libro");
				String id_utente = request.getParameter("id_utente");
				String data_i = request.getParameter("data_inizio");
				String data_f = request.getParameter("data_fine");
				String note = request.getParameter("note");
				
				DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
				LocalDate data_inizio = LocalDate.parse(data_i, f);
				LocalDate data_fine = LocalDate.parse(data_f, f);
				
				JPADBtools.insertPrestito(Integer.parseInt(id_libro), Integer.parseInt(id_utente), data_inizio, data_fine, note);

				request.getSession().setAttribute("nuovoPrestito", "TRUE");	
				
				response.sendRedirect("registraPrestito.jsp");
				break;
			}
			}
		}
	}

}
