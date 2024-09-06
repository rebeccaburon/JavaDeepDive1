package app.Uge2.FridayExcercie_Uge2OG3.DAO;

import app.Uge2.FridayExcercie_Uge2OG3.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LocationDAO {

    private EntityManagerFactory emf;

    public LocationDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Location getLocationById(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Location.class, id);
        }
    }

    public Location createDestionationLocation(Location destinationLocation) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(destinationLocation);
            em.getTransaction().commit();
        }
        return destinationLocation;
    }
    public Location createSourceLocation(Location sourceLocation) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(sourceLocation);
            em.getTransaction().commit();
        }
        return sourceLocation;
    }

    public Set<Location> getAllLocations() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Location> query = em.createQuery("SELECT l FROM Location l", Location.class);
            List<Location> locations = query.getResultList();
            return locations.stream()
                    .collect(Collectors.toSet());
        }
    }

    public Location updateLocation(Location location) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(location);
            em.getTransaction().commit();
        }
        return location;
    }

    public Location deleteLocation(Location location) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
        }
        return location;
    }


}
