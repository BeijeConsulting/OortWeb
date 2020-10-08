package it.beije.oort.bm.library.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.oort.bm.library.Author;
import it.beije.oort.bm.library.Book;
import it.beije.oort.bm.library.Publisher;
import it.beije.oort.bm.library.database.ConcreteDatabase;
import it.beije.oort.bm.library.database.Database;

@WebServlet("/insertService")
public class LibraryInsertService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Database db = ConcreteDatabase.getDatabase();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Publisher publisher = new Publisher();
		publisher.setId(Integer.parseInt(req.getParameter("ins_publisher")));
		publisher = db.searchRecord(Publisher.class, publisher).get(0);
		Author author = new Author();
		author.setId(Integer.parseInt(req.getParameter("ins_author")));
		author = db.searchRecord(Author.class, author).get(0);
		
		Book b = new Book();
		b.setTitle(req.getParameter("ins_title"));
		b.setAuthor(author);
		b.setPublisher(publisher);
		b.setYear(req.getParameter("ins_year"));
		b.setDescription(req.getParameter("ins_descr"));
		
		db.add(b);
		
		resp.sendRedirect("./dispatch?res=books");
	}

}
