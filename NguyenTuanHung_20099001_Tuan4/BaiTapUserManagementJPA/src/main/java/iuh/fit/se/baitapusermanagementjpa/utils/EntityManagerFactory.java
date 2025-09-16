package iuh.fit.se.baitapusermanagementjpa.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EntityManagerFactory {
    private static final jakarta.persistence.EntityManagerFactory entity;

    static {
        try {
            entity = Persistence.createEntityManagerFactory("user-management");

        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);

        }
    }


    public static EntityManager getEntityManager() {
        return entity.createEntityManager();

    }

    public static void close() {
        if (entity.isOpen()) {
            entity.close();
        }
    }

}
