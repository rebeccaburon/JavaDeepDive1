package app.Uge2.FridayExcercie_Uge2OG3.DAO;

import app.Uge2.FridayExcercie_Uge2OG3.entities.Packages;
import app.Uge2.FridayExcercie_Uge2OG3.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PackageDAO {

    private EntityManagerFactory emf;

    public PackageDAO(EntityManagerFactory emf) {
        this.emf = HibernateConfig.getEntityManagerFactory();;
    }

    public Packages getById(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            return em.find(Packages.class, id);
        }
    }
    //Create methood
    public Packages create (Packages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(packages);
            em.getTransaction().commit();
        }
        return packages;
    }
    //Read
    public Set <Packages> getAll() {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery query = em.createQuery("SELECT P FROM Packages P", Packages.class);
            List<Packages> packages = query.getResultList();
            return packages.stream()
                    .collect(Collectors.toSet());
        }
    }


// Update
    public Packages update (Packages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(packages);
            em.getTransaction().commit();
        }
        return packages;
    }
    public Packages delete (Packages packages) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(packages);
            em.getTransaction().commit();
        }
        return packages;
    }
}
