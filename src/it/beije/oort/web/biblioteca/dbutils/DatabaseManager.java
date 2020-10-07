package it.beije.oort.web.biblioteca.dbutils;

import it.beije.oort.web.biblioteca.model.*;
import it.beije.oort.web.biblioteca.utils.Config;
import it.beije.oort.web.database.JPAEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DatabaseManager {
    private static EntityManager em = JPAEntityManager.getEntityManager(Config.getPersistenceUnitName());

    public DatabaseManager(String database) {
        em = JPAEntityManager.getEntityManager(database);
    }

    public static void insert(IBibliotecaModel object){
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public static IBibliotecaModel select(Class<? extends IBibliotecaModel> classe, int id){
        return em.find(classe, id);
    }

    public static boolean exist(Class<? extends IBibliotecaModel> classe, int id){
        return em.find(classe, id) != null;
    }

    public static List<? extends IBibliotecaModel> findAll(Class<? extends IBibliotecaModel> classe) {
        return em.createQuery("Select o from " + classe.getSimpleName() + " as o", IBibliotecaModel.class).getResultList();
    }

    public static Utente getUtenteFromCF(String cf){
        try {
            String jpql = "SELECT u FROM Utente as u WHERE u.codice_fiscale = :cf";
            Query query = em.createQuery(jpql, Utente.class).setParameter("cf", cf);
            return (Utente) query.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Prestito> getPrestitiFromUser(String userCF){
        try {
            String jpql = "SELECT p FROM Prestito as p WHERE p.cfUtente = " +
                    "'" + userCF + "'";
            TypedQuery<Prestito> query = em.createQuery(jpql, Prestito.class);
//                    .setParameter("cf", userCF);
            System.out.println(query.toString());
            return query.getResultList();
        } catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void delete(Class<? extends IBibliotecaModel> classe, int id){
        IBibliotecaModel deleteMe = null;
        try{
            deleteMe = select(classe, id);
        } catch (Exception e){
        }
        em.getTransaction().begin();
        em.remove(deleteMe);
        em.getTransaction().commit();
    }

    public static void deleteUtente(String cf){
        Utente deleteMe = getUtenteFromCF(cf);
        em.getTransaction().begin();
        em.remove(deleteMe);
        em.getTransaction().commit();
    }
}
