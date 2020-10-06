package it.beije.oort.web.tools;

import it.beije.oort.web.model.Contatto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter {
    public static void writeList(List<Contatto> list, String outputPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();
            Element root = document.createElement("rubrica");
            document.appendChild(root);



            for (Contatto c : list) {
                Element contatto = document.createElement("contatto");

                Element nome = document.createElement("nome");
                Element cognome = document.createElement("cognome");
                Element telefono = document.createElement("telefono");
                Element email = document.createElement("email");

                nome.setTextContent(c.getNome());
                cognome.setTextContent(c.getCognome());
                telefono.setTextContent(c.getCell());
                email.setTextContent(c.getEmail());

                contatto.appendChild(nome);
                contatto.appendChild(cognome);
                contatto.appendChild(telefono);
                contatto.appendChild(email);

                root.appendChild(contatto);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);

                StreamResult result = new StreamResult(new File(outputPath));

                transformer.transform(source, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
