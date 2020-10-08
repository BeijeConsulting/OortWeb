package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insPrestito")
public class InsPrestito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> ");
			String libro = request.getParameter("id_libro");
			String utente = request.getParameter("id_utente");
			String datai =  request.getParameter("data_inizio");
			String dataf = request.getParameter("data_fine");
			String note = request.getParameter("note");
			int x = 0;
			if(!libro.equals("")) {
			x = Integer.parseInt(libro);
			}
			int y = 0;
			if(!utente.equals("")) {
			y = Integer.parseInt(utente);
			}
			
			
			EntityManager entityManager = SingletonJPABiblio.openEntity();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Prestiti prestito = new Prestiti();

			try {
			prestito.setLibro(x);;
			prestito.setUtente(y);
			}catch (Exception e){
				System.out.println("Parametro vuoto non possibile!");
			}
			prestito.setDataInizio(datai);
			prestito.setDataFine(dataf);
			prestito.setNote(note);
			entityManager.persist(prestito);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Prestito inserito correttamente!");
			
				
			builder.append("<br>ID LIBRO: ").append(libro).append("<br>ID UTENTE : ").append(utente)
			.append("<br>DATA INIZIO : ").append(datai).append("<br>DATA FINE : ").append(dataf).append("<br>NOTE: ").append(note);

			response.getWriter().append(builder).append("<br>");
			
			StringBuilder b = new StringBuilder("<!doctype html>\r\n" + 
					"<html>\r\n" + 
					"	<head>\r\n" + 
					"	<title></title>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<form action=\"conferma.jsp\" method=\"POST\">\r\n" + 
					"		<br><button type=\"submit\"> MENU' PRINCIPALE</button>\r\n" + 
					"		</form>		\r\n" + 
					"	</body>\r\n" + 
					"</html>");
			response.getWriter().append(b);
	}

}
