package it.beije.oort.sala.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.sala.web.beans.Contatto;
import it.beije.oort.sala.web.db.JPAToolset;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX="<!DOCTYPE html><html><head><meta charset=\"utf-8\">"
			+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title>Cool Site</title>"
			+ "</head><body><header style=\"margin-left: 2em;\"><h1>This is the homepage offered by magical html"
			+ "5.</h1><p>If you click the button below you can go to a special form page and once there you can "
			+ "insert some good old 'Contatto' beans directly into the database.</p>"
			+ "</header><div><form action=\"./form.html\" method=\"GET\" autocomplete=\"off\" style=\"margin-"
			+ "left: 2em;\"><input type=\"submit\" value=\"Go to form\"></form><form action=\"/Servlet1\" "
			+ "method=\"GET\" autocomplete=\"off\" style=\"margin-left: 2em;\"><button name=\"Download\" "
			+ "value=\"Download\">Download</button></form></div></body><html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(request.getParameter("Download").equals("Download")) {
			
			//get a list from db and covert it to csv
			
			response.setContentType("text/csv");
			response.addHeader("Content-Disposition", "attachment; filename=rubrica.csv");
			response.getWriter().append("Test download");
		}
		else response.getWriter().append(INDEX);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		insertContatto(request.getParameter("nome"), request.getParameter("cognome"),
				request.getParameter("telefono"), request.getParameter("email"));
		
		response.sendRedirect("/form.html");
	}
		
	private void insertContatto(String nome, String cognome, String telefono, String email) {
		Contatto c = new Contatto(nome, cognome, telefono, email);
			JPAToolset.insertJPA(c);
	}
}