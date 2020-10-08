package it.beije.oort.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class NuovoLibro
 */
@WebServlet("/NuovoLibro")
public class NuovoLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuovoLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libri libro = new Libri();
		String titolo = request.getParameter("titolo");
		libro.setTitolo(titolo);
		try {
			try {
				int id_autore = Integer.parseInt(request.getParameter("id_autore"));
				libro.setEditore(id_autore);
	
			} catch(NumberFormatException e) {
			}
			try {
				int id_editore = Integer.parseInt(request.getParameter("id_editore"));
				libro.setAutore(id_editore);
			} catch(NumberFormatException e) {
			}
			try {
				int anno = Integer.parseInt(request.getParameter("anno"));
				libro.setAnno(anno);
			} catch(NumberFormatException e) {
			}
			JPDBtools.insert(libro, "OortBiblioteca");
			request.getSession().setAttribute("errore", "Libro Inserito Correttamente");
			response.sendRedirect("menubiblioteca.jsp");
		}catch(Exception e) {
			request.getSession().setAttribute("errore", "Valori Libro Errati");
			response.sendRedirect("menubiblioteca.jsp");
		}
	} 
			
}


