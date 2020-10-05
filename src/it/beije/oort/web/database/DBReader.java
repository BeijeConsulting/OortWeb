package it.beije.oort.web.database;

import it.beije.oort.web.rubrica.Contatto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DBReader {
    public static List<Contatto> getContatti(){
        EntityManager em = JPAEntityManager.getEntityManager();
        return em.createQuery("Select c from Contatto as c", Contatto.class).getResultList();
    }

    public static Contatto searchByID(int id){
        EntityManager em = JPAEntityManager.getEntityManager();
        return em.find(Contatto.class, id);
    }

    public static List<Contatto> searchBy(String column, String query){
        EntityManager em = JPAEntityManager.getEntityManager();
        Query searchQuery = em.createQuery("Select c from Contatto as c WHERE :col = :query", Contatto.class)
                .setParameter("query", query)
                .setParameter("col", column);
        return searchQuery.getResultList();
    }
}
