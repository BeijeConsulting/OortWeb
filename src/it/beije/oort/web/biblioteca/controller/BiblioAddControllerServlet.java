package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.dbutils.DatabaseManager;
import it.beije.oort.web.biblioteca.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/biblioAdd")
public class BiblioAddControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = (String) request.getSession().getAttribute("addType");
        switch (type) {
            case "Libro":
                createLibro(request);
                break;
            case "Editore":
                createEditore(request);
                break;
            case "Autore":
                createAutore(request);
                break;
            case "Utente":
                createUtente(request);
                break;
            case "Prestito":
                createPrestito(request);
                break;
        }
        response.sendRedirect("/OortWeb_war/biblio/biblioAdd.jsp");
    }

    private void createUtente(HttpServletRequest request){
        Utente u = new Utente();
        String nome = request.getParameter("uNome");
        String cognome = request.getParameter("uCognome");
        String cf = request.getParameter("cf");
        String pass = request.getParameter("pass");
        String email = request.getParameter("email");
        String cell = request.getParameter("cell");
        String indirizzo = request.getParameter("indirizzo");
        String isAdmin = request.getParameter("isAdmin");

        u.setAdmin(isAdmin != null && !isAdmin.equalsIgnoreCase(""));

        if (nome != null && !nome.equalsIgnoreCase("")){
            u.setNome(nome);
        }
        if (cognome != null && !cognome.equalsIgnoreCase("")){
            u.setCognome(cognome);
        }
        if (cf != null && !cf.equalsIgnoreCase("")){
            u.setCodice_fiscale(cf);
        }
        if (pass != null && !pass.equalsIgnoreCase("")){
            u.setPassword(pass);
        }
        if (email != null && !email.equalsIgnoreCase("")){
            u.setEmail(email);
        }
        if (cell != null && !cell.equalsIgnoreCase("")){
            u.setCellulare(cell);
        }
        if (indirizzo != null && !indirizzo.equalsIgnoreCase("")){
            u.setIndirizzo(indirizzo);
        }

        DatabaseManager.insert(u);
    }
    private void createPrestito(HttpServletRequest request){
        Prestito p = new Prestito();
        String init = request.getParameter("initPrestito");
        String end = request.getParameter("finePrestito");
        String note = request.getParameter("note");
        String idUser = request.getParameter("prestitoUtente");
        String idLibro = request.getParameter("prestitoLibro");

        if (note != null && !note.equalsIgnoreCase("")){
            p.setNote(note);
        }
        if (init != null && !init.equalsIgnoreCase("")){
            p.setDataInizio(Date.valueOf(init));
        }
        if (end != null && !end.equalsIgnoreCase("")){
            p.setDataFine(Date.valueOf(end));
        }

        if (idUser != null && !idUser.equalsIgnoreCase("")){
            p.setCfUtente(idUser);
        }

        if (idLibro != null && !idLibro.equalsIgnoreCase("")){
            try {
                p.setIdLibro(Integer.parseInt(idLibro));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        DatabaseManager.insert(p);
    }

    private void createLibro(HttpServletRequest request){
        Libro l = new Libro();
        String titolo = request.getParameter("titolo");
        String descrizione = request.getParameter("desc");
        String anno = request.getParameter("anno");
        String idAutore = request.getParameter("autore");
        String idEditore = request.getParameter("editore");

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
    private void createEditore(HttpServletRequest request){
        Editore e = new Editore();
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descEditore");

        if (nome != null && !nome.equalsIgnoreCase("")){
            e.setNome(nome);
        }
        if (descrizione != null && !descrizione.equalsIgnoreCase("")){
            e.setDescrizione(descrizione);
        }

        DatabaseManager.insert(e);
    }

    private void createAutore(HttpServletRequest request){
        Autore a = new Autore();
        String nome = request.getParameter("nomeAutore");
        String cognome = request.getParameter("cognomeAutore");
        String dataNasc = request.getParameter("autDataNasc");
        String dataMort = request.getParameter("autDataMorte");
        String bio = request.getParameter("bio");

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
}
