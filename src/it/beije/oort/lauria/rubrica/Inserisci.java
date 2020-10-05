package it.beije.oort.lauria.rubrica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inserisci
 */
@WebServlet("/Inserisci")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserisci() {
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
		
		StringBuilder builder = new StringBuilder("<h2>Dati registrati con successo<h2><br>");
		builder.append("<a href="+"./home.html" + ">home</a>");
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		JPADBtoolsRubrica.insertContact(nome, cognome, telefono, email);
		
		builder.append("NOME : ").append(nome).append("<br/>COGNOME : ").append(cognome).append("<br/>TELEFONO : ")
				.append(telefono).append("<br/>EMAIL : ").append(email);

		response.getWriter().append(builder);
	}

}
