package it.beije.oort.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class NuovoElemento
 */
@WebServlet("/NuovoAutore")
public class NuovoAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoAutore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				Autori autore = new Autori();
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String bio = request.getParameter("biografia");
				autore.setNome(nome);
				autore.setCognome(cognome);
				autore.setBiografia(bio);
				try {
					LocalDate data_nascita = LocalDate.parse(request.getParameter("data_nascita"));
					LocalDate data_morte = LocalDate.parse(request.getParameter("data_morte"));
					autore.setData_nascita(data_nascita);
					autore.setData_morte(data_morte);
				}catch(DateTimeParseException e) {
				}
				JPDBtools.insert(autore, "OortBiblioteca");
				request.getSession().setAttribute("errore", "Autore Inserito Correttamente");
				response.sendRedirect("menubiblioteca.jsp");
			}
				catch(Exception e) {
					request.getSession().setAttribute("errore", "Errore Valori Autore");
					response.sendRedirect("menubiblioteca.jsp");
				}
	}

}
