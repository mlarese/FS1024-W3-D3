package it.epicode.libri;
 
import jakarta.persistence.EntityManager;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em) {
        this.em = em;
    }

    public Libro findById(Long id) {
        return em.find(Libro.class, id);
    }

    public void insert(Libro a) {
        em.persist(a);
    }

    public void update(Libro a) {
        em.merge(a);
    }

    public void delete(Long id) {
        Libro a = findById(id);
        em.remove(a);
    }
}
