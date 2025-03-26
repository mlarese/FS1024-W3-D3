package it.epicode;

import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCaricaLibro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        // creiamo un entity manager
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);

        Libro l = libroDAO.findById(1L);

        System.out.println(l);

        //System.out.println("Libro letto: " + l.getTitolo() + " " + l.getAutore().getCognome() );

        em.close();
        emf.close();


    }
}
