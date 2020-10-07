package it.beije.oort.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class NewPrestito
 */
@WebServlet("/NuovoPrestito")
public class NuovoPrestito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoPrestito() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String utente = request.getParameter("IdUtente");
		String libro = request.getParameter("IdLibro");
		String note = request.getParameter("Note");
		String data_inizio = request.getParameter("Data_Inizio");
		String data_fine = request.getParameter("Data_Fine");
		LocalDate init_date;
		LocalDate end_date; 
		try { //se esce qualche eccezione stoppo tutto e do errore
			Prestiti prestito = new Prestiti();
			prestito.setLibro(Integer.parseInt(libro));
			prestito.setUtente(Integer.parseInt(utente));
			init_date =  LocalDate.parse(data_inizio);
			prestito.setData_inizio(init_date);
			if(note!="") prestito.setNote(note);
			try {
				end_date = LocalDate.parse(data_fine);
				prestito.setData_fine(end_date);			
			} catch(DateTimeParseException e) {
			}
			JPDBtools.insert(prestito, "OortBiblioteca");
			request.getSession().setAttribute("errore", "Prestito Inserito Correttamente");
			response.sendRedirect("menubiblioteca.jsp");

		} catch(Exception e) {
			request.getSession().setAttribute("errore", "Valori Nuovo Prestito Errati");
			response.sendRedirect("menubiblioteca.jsp");
		}
	}
}