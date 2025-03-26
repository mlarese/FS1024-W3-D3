package it.epicode.categorie;
import jakarta.persistence.EntityManager;

public class CategoriaDAO {
    private EntityManager em;

    public CategoriaDAO(EntityManager em) {
        this.em = em;
    }

    public Categoria findById(Long id) {
        return em.find(Categoria.class, id);
    }

    public void insert(Categoria a) {
        em.persist(a);
    }

    public void update(Categoria a) {
        em.merge(a);
    }

    public void delete(Long id) {
        Categoria a = findById(id);
        em.remove(a);
    }
}
