package it.beije.oort.bm.rubrica.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import it.beije.oort.bm.rubrica.Contatto;
import it.beije.oort.bm.rubrica.database.Database;
import it.beije.oort.bm.rubrica.database.JPADatabase;


@WebServlet
public class RubricaService extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	private static Database db = JPADatabase.getDatabase();
	private static int count = 0;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			updateDocument();
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
//		resp.sendRedirect("./index.html");
		List<Contatto> l = db.selectAll();
		for(Contatto c : l) {
			resp.getWriter().append(c.toString()).append('\n');
		}
		System.out.println("Richiesta gestita " + count++);
	}

	

//	private static synchronized void updateDocument() throws TransformerException {
//		Document index = null;
//		try {
//			index = loadDocument();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return;
//		}
//		Element table = index.getDocumentElement();
//		table = (Element)table.getElementsByTagName("table");
//		NodeList l = table.getChildNodes();
//		while(l.getLength() > 0) {
//			table.removeChild(l.item(0));
//		}
//		Element tabHeader = index.createElement("tr");
//		Element header = index.createElement("th");
//		header.setTextContent(H1);
//		tabHeader.appendChild(header);
//		header = index.createElement("th");
//		header.setTextContent(H2);
//		tabHeader.appendChild(header);
//		header = index.createElement("th");
//		header.setTextContent(H3);
//		tabHeader.appendChild(header);
//		header = index.createElement("th");
//		header.setTextContent(H4);
//		tabHeader.appendChild(header);
//		table.appendChild(tabHeader);
//		List<Contatto> contacts = db.selectAll();
//		for(Contatto c : contacts) {
//			Element row = index.createElement("tr");
//			Element field = index.createElement("td");
//			field.setTextContent(c.getNome());
//			row.appendChild(field);
//			field = index.createElement("td");
//			field.setTextContent(c.getCognome());
//			row.appendChild(field);
//			field = index.createElement("td");
//			field.setTextContent(c.getTelefono());
//			row.appendChild(field);
//			field = index.createElement("td");
//			field.setTextContent(c.getEmail());
//			row.appendChild(field);
//			table.appendChild(row);
//		}
//		
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(index);
//		
//		StreamResult result = new StreamResult(INDEX);
//
//		transformer.transform(source, result);
//		
//	}



//	private static Document loadDocument() throws ParserConfigurationException, SAXException, IOException {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//		
//        Document document = builder.parse(INDEX);
//		return document;
//	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
