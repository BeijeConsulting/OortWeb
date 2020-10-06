package it.beije.oort.web.biblioteca.controller;



import it.beije.oort.web.biblioteca.model.Autore;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;
import it.beije.oort.web.biblioteca.model.Libro;
import it.beije.oort.web.biblioteca.utils.Config;
import it.beije.oort.web.biblioteca.utils.Paginator;
import it.beije.oort.web.biblioteca.utils.Utils;
import it.beije.oort.web.database.JPAEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class ProgramBasicOperations {
    private final static Scanner sc = new Scanner(System.in);

    public final static EntityManager em = JPAEntityManager.getEntityManager(Config.getPersistenceUnitName());


    private ProgramBasicOperations(){}

    public static void showAuthorDetails(){
        System.out.println("Inserisci l'ID dell'autore di cui vuoi vedere i dettagli.");
        int idAutore = Utils.getUserInput(sc);
        if (!DatabaseManager.exist(Autore.class, idAutore)) {
            System.err.println("ID autore non presente.");
            return;
        }
        Autore autore = (Autore) DatabaseManager.select(Autore.class, idAutore);

        System.out.println(autore);
        System.out.println("Libri dell'Autore: ");

        getBooksFromAuthor(idAutore);
        Paginator.pageManager();
    }


    public static void getBooksFromAuthor(int idAutore){
        String jpql = "SELECT b FROM Libro as b WHERE b.id_autore = :idAutore";
        TypedQuery<? extends IBibliotecaModel> query = em.createQuery(jpql, Libro.class)
                .setParameter("idAutore", idAutore);
        Main.resultList = query.getResultList();
    }
}
