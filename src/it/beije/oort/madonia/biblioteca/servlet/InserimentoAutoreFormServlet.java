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
 * Servlet implementation class InserimentoAutoreServlet
 */
@WebServlet("/biblioteca/InserimentoAutoreForm")
public class InserimentoAutoreFormServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoAutoreFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dataNascita = request.getParameter("dataNascita");
		String dataMorte = request.getParameter("dataMorte");
		System.out.println(dataNascita);
		System.out.println(dataMorte);
		
		Autore autore = new Autore();
		autore.setNome(request.getParameter("nome"));
		autore.setCognome(request.getParameter("cognome"));
		autore.setBiografia(request.getParameter("biografia"));
		autore.setDataNascita(dataNascita.length() > 0 ? Date.valueOf(dataNascita) : null);
		autore.setDataMorte(dataMorte.length() > 0 ? Date.valueOf(dataMorte) : null);
		
		try {
			DatabaseManagerBiblioteca.inserisci(autore);
			request.getSession().setAttribute("success", "Autore inserito correttamente: " + autore);
		} catch (Exception e) {
			request.getSession().setAttribute("errore", "L'autore non è stato inserito: " + e.getMessage());
		} finally {
			response.sendRedirect("./InserimentoAutore");
		}
	}

}
