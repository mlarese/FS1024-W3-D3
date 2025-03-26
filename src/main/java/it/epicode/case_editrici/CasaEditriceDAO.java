package it.epicode.case_editrici;
import jakarta.persistence.EntityManager;

public class CasaEditriceDAO {
    private EntityManager em;

    public CasaEditriceDAO(EntityManager em) {
        this.em = em;
    }

    public CasaEditrice findById(Long id) {
        return em.find(CasaEditrice.class, id);
    }

    public void insert(CasaEditrice a) {
        em.persist(a);
    }

    public void update(CasaEditrice a) {
        em.merge(a);
    }

    public void delete(Long id) {
        CasaEditrice a = findById(id);
        em.remove(a);
    }
}
