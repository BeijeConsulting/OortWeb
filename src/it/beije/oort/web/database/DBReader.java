package it.beije.oort.web.database;


import it.beije.oort.web.model.Contatto;
import it.beije.oort.web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    public static User getUser(String email){
        EntityManager em = JPAEntityManager.getEntityManager("rubrica");
        User user;
        try{
            user = em.createQuery("Select c from User as c WHERE email LIKE "
                    + "'%" + email + "%'" +"", User.class)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        return user;
    }
}
