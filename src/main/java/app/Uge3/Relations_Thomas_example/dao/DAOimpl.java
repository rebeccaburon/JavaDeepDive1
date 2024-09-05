package app.Uge3.Relations_Thomas_example.dao;

import app.Uge3.Relations_Thomas_example.entities.Adress;
import app.Uge3.Relations_Thomas_example.entities.Emloyee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class DAOimpl implements IDAO<Emloyee> {

    EntityManagerFactory emf;

    public DAOimpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void create(Emloyee emp) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Adress adress = emp.getAdress();
            String street = adress.getStreet();
            TypedQuery<Adress> query = em.createQuery("SELECT a FROM Adress a WHERE a.street = :street", Adress.class);
            query.setParameter("street", street);
            if (adress != null) {
                try {
                    Adress found = query.getSingleResult();
                    emp.setAdress(found);
                } catch (NoResultException e) {
                    em.persist(adress);
                }
            }
            em.persist(emp);
            em.getTransaction().commit();
        }
    }

    @Override
    public Emloyee getById(int id) {
        try(EntityManager em = emf.createEntityManager()) {
            return em.find(Emloyee.class, id);
        }
    }

    public void update (Emloyee emp) {
        try (EntityManager em = emf.createEntityManager()) {
            em.find(Emloyee.class, emp.getId());
            ///
            em.getTransaction().begin();

        }
    }


}
