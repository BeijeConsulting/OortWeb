package it.beije.oort.web.database;

import it.beije.oort.web.rubrica.Contatto;

import javax.persistence.EntityManager;
import java.util.List;

public class DBReader {
    public static List<Contatto> getContatti(){
        EntityManager em = JPAEntityManager.getEntityManager();
        return em.createQuery("Select c from Contatto as c", Contatto.class).getResultList();
    }
}
