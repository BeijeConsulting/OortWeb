package it.beije.oort.web.biblioteca;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.beije.oort.web.biblioteca.SingletonJPABiblio;

@WebServlet("/inslibro")
public class InsLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			StringBuilder builder = new StringBuilder("<h3>Dati ricevuti correttamente e aggiunti al DB!</h3> ");
			String titolo = request.getParameter("titolo");
			String desc = request.getParameter("descrizione");
			String autore =  request.getParameter("autore");
			String editore = request.getParameter("editore");
			int x = 0;
			if(!autore.equals("")) {
			x = Integer.parseInt(autore);
			}
			int y = 0;
			y = Integer.parseInt(editore);
			
			String anno = request.getParameter("anno");
			
			EntityManager entityManager = SingletonJPABiblio.openEntity();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Libri libro = new Libri();

			libro.setTitolo(titolo);
			libro.setDescrizione(desc);
			try {
			libro.setAutore(x);
			libro.setEditore(y);
			}catch (Exception e){
				System.out.println("Parametro vuoto non possibile!");
			}
			libro.setAnno(anno);
			entityManager.persist(libro);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("Contatto inserito correttamente!");
			
				
			builder.append("<br>TITOLO : ").append(titolo).append("<br>DESCRIZIONE : ").append(desc)
			.append("<br>AUTORE : ").append(autore).append("<br>EDITORE : ").append(editore).append("<br>ANNO: ").append(anno);

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
