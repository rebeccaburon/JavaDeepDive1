package app.Uge2.FridayExcercie.DAO;

import app.Uge2.FridayExcercie.entities.GLSPackages;
import app.Uge2.FridayExcercie.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PackageDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    //Create methood
    public void create (GLSPackages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(packages);
            em.getTransaction().commit();
        }
    }
    //Read
    public Set <GLSPackages> getAll() {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery query = em.createQuery("SELECT P FROM GLSPackages P", GLSPackages.class);
            List<GLSPackages> packages = query.getResultList();
            return packages.stream()
                    .collect(Collectors.toSet());
        }
    }


// Update
    public void update (GLSPackages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(packages);
            em.getTransaction().commit();
        }
    }
    public void delete (GLSPackages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(packages);
            em.getTransaction().commit();
        }
    }
}
