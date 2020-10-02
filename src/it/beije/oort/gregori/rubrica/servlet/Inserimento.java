package it.beije.oort.gregori.rubrica.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.gregori.rubrica.db.*;
import it.beije.oort.rubrica.Contatto;

/**
 * Servlet implementation class Visualizza
 */
@WebServlet("/Visualizza")
public class Inserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder builder = new StringBuilder();
		File file = new File("/Users/Padawan11/git/OortWeb/WebContent/struttura.html");
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		Contatto contatto = new Contatto(nome, cognome, telefono, email);
		
		Inserimento.inserisciContatto(contatto);
		
		while(buffer.ready()) {
			String s = buffer.readLine();
			if(s.trim().equals("<h1>To be changed</h1>")) {
				s = "<h1>Inserimento</h1>";
			}
			else if(s.trim().equals("%!*replace me*!%")) {
				s = Inserimento.tableContatto(contatto);
			}
			builder.append(s);
		}
		
		buffer.close();
		fileReader.close();
		
		response.getWriter().append(builder);
	}

	private static void inserisciContatto(Contatto contatto) {
		List<Contatto> contatti = new ArrayList<Contatto>();
		contatti.add(contatto);
		WriterDb.writeContatti(contatti);
	}
	
	private static String tableContatto(Contatto contatto) {
		StringBuilder builder = new StringBuilder();
		String begin = "<h3>Contatto inserito</h3><div class=\"table-wrapper\"><table><thead><tr><th>Nome</th><th>Cognome</th><th>Telefono</th><th>Email</th></tr></thead><tbody>";
		String end = "</tbody></table></div>";
		builder.append(begin);
		

		builder.append("<tr>")
					.append("<td>").append(contatto.getNome()).append("</td>")
					.append("<td>").append(contatto.getCognome()).append("</td>")
					.append("<td>").append(contatto.getTelefono()).append("</td>")
					.append("<td>").append(contatto.getEmail()).append("</td>")
				.append("</tr>");
		
		builder.append(end);
		
		return builder.toString();
	}

}
