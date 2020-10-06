package it.beije.oort.web.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAEntityManager {
    private JPAEntityManager(){}

    private static final Map<String, EntityManager> managerMap = new HashMap<>();

    private final static String database = "rubrica";
    public static EntityManager getEntityManager(){
        if (managerMap.get(database) == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(database);
            EntityManager em = entityManagerFactory.createEntityManager();
            managerMap.put(database, em);
        }
        return managerMap.get(database);
    }

    public static EntityManager getEntityManager(String customDatabase){
        if (managerMap.get(customDatabase) == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(customDatabase);
            EntityManager em = entityManagerFactory.createEntityManager();
            managerMap.put(customDatabase, em);
        }
        return managerMap.get(customDatabase);
    }
}