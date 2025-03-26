package it.epicode;

import it.epicode.autori.Autore;
import it.epicode.autori.AutoreDAO;
import it.epicode.case_editrici.CasaEditrice;
import it.epicode.case_editrici.CasaEditriceDAO;
import it.epicode.categorie.Categoria;
import it.epicode.categorie.CategoriaDAO;
import it.epicode.libri.Libro;
import it.epicode.libri.LibroDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class MainCreaLibro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        LibroDAO libroDAO = new LibroDAO(em);
        AutoreDAO autoreDAO = new AutoreDAO(em);
        CasaEditriceDAO casaEditriceDAO = new CasaEditriceDAO(em);

        Autore autore = new Autore(null,"Andrea", "Marchi","italiana" );
        Autore autore2 = new Autore(null,"Giovanni", "Di balle","italiana" );

        CasaEditrice casaEditrice = new CasaEditrice(null, "Mondadori", "Italia", LocalDate.of(2000, 1, 1));

        Categoria fantasy = new Categoria(null, "Fantasy");
        Categoria giallo = new Categoria(null, "Giallo");
        Categoria horror = new Categoria(null, "Horror");
        Categoria narrativa = new Categoria(null, "Narrativa");

        em.getTransaction().begin();

        // le salvo direttamente perchè non sono inserite nel libro
        categoriaDAO.insert(horror);
        categoriaDAO.insert(narrativa);
        // non serve salvare fantasy e giallo perchè sono già presenti nel libro
        // per cui vengono salvati a cascata nel momento in cui salvo il libro

        //casaEditriceDAO.insert(casaEditrice);
        //autoreDAO.insert(autore);


        Libro libro = new Libro(null, "Acqua azzurra", autore, casaEditrice, List.of( fantasy, giallo));
        Libro libro1 = new Libro(null, "Acqua chiara", autore2, casaEditrice, List.of( fantasy, giallo));

        libroDAO.insert(libro);
        libroDAO.insert(libro1);

        em.getTransaction().commit();

        libroDAO.findById(1L);

        em.close();
        emf.close();


    }
}
