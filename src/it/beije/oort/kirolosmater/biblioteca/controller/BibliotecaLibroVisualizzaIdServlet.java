package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiLibro.readRecordFromDb;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.oort.kirolosmater.biblioteca.model.Libro;

/**
 * Servlet implementation class BibliotecaLibroVisualizzaIdServlet
 */
@WebServlet("/biblioteca/view/BibliotecaLibroVisualizzaIdServlet")
public class BibliotecaLibroVisualizzaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BibliotecaLibroVisualizzaIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro = readRecordFromDb(id);
		String titolo = libro.getTitolo();
		String autore = libro.getAutore();
		String editore = libro.getEditore();
		int anno = libro.getAnno();
		String descrizione = libro.getDescrizione();
		session.setAttribute("titolo", titolo);
		session.setAttribute("autore", autore);
		session.setAttribute("editore", editore);
		session.setAttribute("anno", anno);
		session.setAttribute("descrizione", descrizione);
		response.sendRedirect("visualizzaLibroId.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
