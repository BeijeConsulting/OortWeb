package it.beije.oort.lauria.rubrica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Visualizza
 */
@WebServlet("/Visualizza")
public class Visualizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visualizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//StringBuilder builder = new StringBuilder("<h2>Dati registrati con successo</h2><br>");
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html>");
		builder.append("<html><head><style>table {font-family: arial, sans-serif;width: 100%;}td, th { border: 1px solid #dddddd;text-align: left;padding: 8px;}tr:nth-child(even) {background-color: #dddddd;}</style></head>");		
		builder.append("<body><table>");
		
		builder.append("<a href="+"./home.html" + ">home</a><br>");
		
		List<Contatto> contatti = JPADBtoolsRubrica.selectContacts();
		builder.append("<h3>").append("Contatti in rubrica: ").append(contatti.size()).append("</h3>");
		builder.append("<tr><th>id</th><th>Nome</th><th>Cognome</th><th>Telefono</th><th>Email</th></tr>");
		
		for (Contatto contatto : contatti) {
			builder.append("<tr>");
		builder.append("<td>").append(contatto.getId()).append("</td>")
		.append("<td>").append(contatto.getNome()).append("</td>")
		.append("<td>").append(contatto.getCognome()).append("</td>")
		.append("<td>").append(contatto.getTelefono()).append("</td>")
		.append("<td>").append(contatto.getEmail()).append("</td>");
		builder.append("</tr>");
		}
		
		builder.append("</table></body></html>");
//		for (Contatto contatto : contatti) {
//		builder.append("<p>id : ").append(contatto.getId())
//		.append("<br/>Nome : ").append(contatto.getNome())
//		.append("<br/>Cognome : ").append(contatto.getCognome())
//		.append("<br/>Telefono : ").append(contatto.getTelefono())
//		.append("<br/>Email : ").append(contatto.getEmail())
//		.append("</p><br>");
//		}

		response.getWriter().append(builder);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
