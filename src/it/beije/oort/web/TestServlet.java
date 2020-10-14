package it.beije.oort.web;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        System.out.println("TestServlet creata");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StringBuilder builder = new StringBuilder("<!DOCTYPE html>");
		builder.append("<html><head><meta charset=\"ISO-8859-1\"><title>OortWeb</title></head><body><h1>Ciao Sono una servlet :-)</h1>");
		builder.append("<br/><p>Sono le ").append(LocalTime.now().format(DateTimeFormatter.ISO_TIME)).append("</p></body></html>");
		
		response.getWriter().append(builder.toString());
		//response.getWriter().append("Ciao sei su: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("post...");
		
		StringBuilder builder = new StringBuilder("Dati ricevuti\n");
		
//		Enumeration<String> e =	request.getParameterNames();
//		while(e.hasMoreElements()) {
//			String paramName = e.nextElement();
//			System.out.println(paramName);
//			builder.append(paramName).append(" : ").append(request.getParameter(paramName)).append('\n');
//		}

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
//		String telefono = request.getParameter("telefono");
//		String email = request.getParameter("email");
		
		//elaborazione....
		Utente utente = new Utente();
		utente.setNome(nome);
		utente.setCognome(cognome);		
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionUser", utente);
		
		//builder.append("<br/>NOME : ").append(nome).append("<br/>COGNOME : ").append(cognome);

		//response.getWriter().append(builder);
		
		response.sendRedirect("index.jsp");
	}

}
