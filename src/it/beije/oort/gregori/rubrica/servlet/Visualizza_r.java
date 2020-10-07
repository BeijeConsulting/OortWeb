package it.beije.oort.gregori.rubrica.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
public class Visualizza_r extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Visualizza_r() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuilder builder = new StringBuilder();
		File file = new File("/Users/Padawan11/git/OortWeb/WebContent/visualizzazione.html");
		FileReader fileReader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(fileReader);
		
		while(buffer.ready()) {
			String s = buffer.readLine();
			if(s.trim().equals("%!*replace me*!%")) {
				System.out.println(s);
				s = Visualizza_r.createTable();
				System.out.println(s);
			}
			builder.append(s);
		}
		
		buffer.close();
		fileReader.close();
		
		response.getWriter().append(builder);
	}
	
	private static String createTable() {
		StringBuilder builder = new StringBuilder();
		String begin = "<h3>Contatti</h3><div class=\"table-wrapper\"><table><thead><tr><th>Nome</th><th>Cognome</th><th>Telefono</th><th>Email</th></tr></thead><tbody>";
		String end = "</tbody></table></div>";
		builder.append(begin);
		
		List<Contatto> contatti = ReaderDb.readContatti();
		
		for(Contatto contatto : contatti) {
			builder.append("<tr>")
						.append("<td>").append(contatto.getNome()).append("</td>")
						.append("<td>").append(contatto.getCognome()).append("</td>")
						.append("<td>").append(contatto.getTelefono()).append("</td>")
						.append("<td>").append(contatto.getEmail()).append("</td>")
					.append("</tr>");
		}
		
		builder.append(end);
		
		return builder.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
