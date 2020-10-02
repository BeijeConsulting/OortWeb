package it.beije.oort.web.database;

import it.beije.oort.web.rubrica.Contatto;

import javax.persistence.EntityManager;

public class DBWriter {
    public static void writeContatto(Contatto c){
        EntityManager em = JPAEntityManager.getEntityManager();
        System.out.println(em.toString());
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
