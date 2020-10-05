package it.beije.oort.web.database;

import it.beije.oort.web.rubrica.Contatto;

import javax.persistence.EntityManager;
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
        return em.createQuery("Select c from Contatto as c WHERE "
                + column + " LIKE "
                + "'%" + query + "%'" +"", Contatto.class)
                .getResultList();
    }
}
