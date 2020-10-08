package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.Autore;
import it.beije.oort.web.biblioteca.model.Libro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/update")
public class BiblioUpdaterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = (String) request.getSession().getAttribute("modifyMeClass");
        switch (type) {
            case "Libro":
                updateLibro(request);
                break;
//            case "Editore":
//                createEditore(request);
//                break;
            case "Autore":
                updateAutore(request);
                break;
//            case "Utente":
//                createUtente(request);
//                break;
//            case "Prestito":
//                createPrestito(request);
//                break;
        }
//        response.sendRedirect("/OortWeb_war/biblio/biblioAdd.jsp");
        response.getWriter().println("modificato!");
    }

    private void updateAutore(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("modifyMeID");
        String nome = request.getParameter("nomeAutore");
        String cognome = request.getParameter("cognomeAutore");
        String dataNasc = request.getParameter("autDataNasc");
        String dataMort = request.getParameter("autDataMorte");
        String bio = request.getParameter("bio");

        Autore a = (Autore) DatabaseManager.select(Autore.class, id);

        if (nome != null && !nome.equalsIgnoreCase("")){
            a.setNome(nome);
        }
        if (cognome != null && !cognome.equalsIgnoreCase("")){
            a.setCognome(cognome);
        }
        if (dataNasc != null && !dataNasc.equalsIgnoreCase("")){
            a.setData_nascita(Date.valueOf(dataNasc));
        }
        if (dataMort != null && !dataMort.equalsIgnoreCase("")){
            a.setData_morte(Date.valueOf(dataMort));
        }
        if (bio != null && !bio.equalsIgnoreCase("")){
            a.setBiografia(bio);
        }

        DatabaseManager.insert(a);
    }

    private void updateLibro(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("modifyMeID");
        String titolo = request.getParameter("titolo");
        String descrizione = request.getParameter("desc");
        String anno = request.getParameter("anno");
        String idAutore = request.getParameter("autore");
        String idEditore = request.getParameter("editore");

        Libro l = (Libro) DatabaseManager.select(Libro.class, id);

        if (titolo != null && !titolo.equalsIgnoreCase("")){
            l.setTitolo(titolo);
        }
        if (anno != null && !anno.equalsIgnoreCase("")){
            l.setAnno_pubblicazione(Date.valueOf(anno));
        }
        if (descrizione != null && !descrizione.equalsIgnoreCase("")){
            l.setDescrizione(descrizione);
        }
        if (idAutore != null && !idAutore.equalsIgnoreCase("")){
            try {
                l.setId_autore(Integer.parseInt(idAutore));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if (idEditore != null && !idEditore.equalsIgnoreCase("")){
            try {
                l.setId_editore(Integer.parseInt(idEditore));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        DatabaseManager.insert(l);
    }
}
