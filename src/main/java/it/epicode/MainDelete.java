package it.epicode;

import it.epicode.autori.AutoreDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        AutoreDAO autoreDAO = new AutoreDAO(em);


        em.getTransaction().begin();

            autoreDAO.delete(2L);


        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
