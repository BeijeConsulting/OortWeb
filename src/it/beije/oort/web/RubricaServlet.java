package it.beije.oort.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.rubrica.Contatto;
import it.beije.oort.sb.jpa.JPDBtools;

/**
 * Servlet implementation class InserimentoContatto
 */
@WebServlet("/rubricaServlet")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RubricaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int indice=0;
		if(request.getParameter("indice")!=null) {
		indice = Integer.parseInt(request.getParameter("indice"));
		}
		String campo ="";
		String valore="";	

		if(request.getParameter("campo")!=null) campo = request.getParameter("campo");
		if(request.getParameter("valore")!=null) valore = request.getParameter("valore");
		if(indice!=0) {
			JPDBtools.delete("Contatto", indice, "OortRubrica");
			response.getWriter().append("Contatto cancellato");
		}
		
		if(!campo.equals("")&&!valore.equals("")) response.getWriter()
		.append(htmlPageContatto(campo, valore, "<h3>Ecco i contatti con quelle caratteristiche</h3>"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("nome")!=null) {
		StringBuilder builder = new StringBuilder("Contatto salvato\n");
		Contatto c = new Contatto();
		c.setNome(request.getParameter("nome"));
		c.setCognome(request.getParameter("cognome"));
		c.setTelefono(request.getParameter("telefono"));
		c.setEmail(request.getParameter("email"));	
		JPDBtools.insert(c, "OortRubrica");
		System.out.println("Contatto salvato in rubrica");
		response.getWriter().append(builder);
		}
	}
	
	//lo utilizzavo prima di utilizzare le jsp per crearmi una html
	private static StringBuilder htmlPageContatto(String campo, String attributo, String funzione) {
		StringBuilder builder = new StringBuilder("<!DOCTYPE html>");
		builder.append("<html><head><meta charset='ISO-8859-1'><title>Delete Contact</title><style></style>")
		.append("</head><body>").append(funzione);//);
		for(Contatto c : JPDBtools.listContatto(campo, attributo)) { //il metodo cosi ormai non esiste piu
			builder.append("<p> Id : ")
			.append(c.getId()).append(" Nome : ").append(c.getNome()).append(" Cognome : ").append(c.getCognome())
			.append(" Email : ").append(c.getEmail()).append(" Telefono : ").append(c.getTelefono()).append("</p>");
		}
		if(campo.equals("")) builder.append("<form action='./rubricaServlet' method='get'>")
		.append("DIGITA L'INDICE DEL CONTATTO&nbsp;<input type='text' name='indice' value='' placeholder='1'/><br/>")
		.append("<input type='submit' value='INVIO'/> <button type='reset'>Annulla</button></form>");
		builder.append("</body></html>");
		return builder;
	}

}
