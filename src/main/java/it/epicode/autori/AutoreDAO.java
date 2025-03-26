package it.epicode.autori;

import jakarta.persistence.EntityManager;

public class AutoreDAO {
    private EntityManager em;

    public AutoreDAO(EntityManager em) {
        this.em = em;
    }

    public Autore findById(Long id) {
        return em.find(Autore.class, id);
    }

    public void insert(Autore a) {
        em.persist(a);
    }

    public void update(Autore a) {
        em.merge(a);
    }

    public void delete(Long id) {
        Autore a = findById(id);
        em.remove(a);
    }
}
