package it.beije.oort.web.database;

import it.beije.oort.web.model.Contatto;

import javax.persistence.EntityManager;

public class DBWriter {
    public static void writeContatto(Contatto c){
        EntityManager em = JPAEntityManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
