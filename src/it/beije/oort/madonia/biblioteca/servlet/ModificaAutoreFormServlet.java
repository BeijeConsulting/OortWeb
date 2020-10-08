package it.beije.oort.madonia.biblioteca.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

/**
 * Servlet implementation class ModificaAutoreFormServlet
 */
@WebServlet("/biblioteca/ModificaAutoreForm")
public class ModificaAutoreFormServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAutoreFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String submit = (String) request.getParameter("submit");
		
		if (submit.equals("id")) {
			int id = Integer.parseInt((String) request.getParameter("id"));
			Autore autore = DatabaseManagerBiblioteca.trovaAutore(id);
			if (autore == null) {
				request.getSession().setAttribute("errore", "Autore non trovato");
			} else {
				request.getSession().setAttribute("success", "Autore trovato: " + autore);
			}
			request.getSession().setAttribute("idAutoreSelezionato", id);
			request.getSession().setAttribute("autoreSelezionato", autore);
			response.sendRedirect("./ModificaAutore.jsp");
		} else if (submit.equals("modifica")) {
			String dataNascita = request.getParameter("dataNascita");
			String dataMorte = request.getParameter("dataMorte");
			System.out.println(dataNascita);
			System.out.println(dataMorte);
			
			
			Autore autore = new Autore();
			autore.setId(Integer.parseInt(request.getParameter("idAutore")));
			autore.setNome(request.getParameter("nome"));
			autore.setCognome(request.getParameter("cognome"));
			autore.setBiografia(request.getParameter("biografia"));
			autore.setDataNascita(dataNascita.length() > 0 ? Date.valueOf(dataNascita) : null);
			autore.setDataMorte(dataMorte.length() > 0 ? Date.valueOf(dataMorte) : null);
			
			try {
				DatabaseManagerBiblioteca.modifica(autore);
				request.getSession().setAttribute("success", "Autore modificato");
			} catch (Exception e) {
				throw e;
			} finally {
				response.sendRedirect("./ModificaAutore.jsp");
			}
			}
		}

}
