package it.beije.oort.web.biblioteca.controller;

import it.beije.oort.web.biblioteca.model.Utente;
import it.beije.oort.web.biblioteca.model.IBibliotecaModel;
import it.beije.oort.web.biblioteca.utils.Config;
import it.beije.oort.web.database.JPAEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        return em.createQuery("Select o from " + classe.getSimpleName() + "as o", IBibliotecaModel.class).getResultList();
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
}
