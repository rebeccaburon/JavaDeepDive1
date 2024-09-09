package app.Uge2.FridayExcercie_Uge2OG3.entities;

import app.Uge2.FridayExcercie_Uge2OG3.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {
    private static EntityManagerFactory emf;
    private static Location location;

    Location location1, location2, location3;

    @BeforeAll
    static void setUp() {
        HibernateConfig.setTestMode(true);
        emf = HibernateConfig.getEntityManagerFactory();
        location = new Location(emf);
    }

    @AfterAll
    static void tearDown() { HibernateConfig.setTestMode(false);}

    @BeforeEach
    void setUpEach() {
        EntityManager em = emf.createEntityManager();
        location1 = new Location(32.22, 58.88,"TesterAdresse vej 1");
        location2 = new Location(85.78, 76.21,"TesterAdresse vej 2");
        location3  = new Location(35.23, 98.37,"TesterAdresse vej 3");

        em.getTransaction().begin();
        em.persist(location1);
        em.persist(location2);
        em.persist(location3);
        em.getTransaction().commit();
    }

    @Test
    void addSourcesLocation() {
        EntityManager em = emf.createEntityManager();
        Shipment shipment1 = new Shipment();

        // Adding a shipment as a sourcelocation
        em.getTransaction().begin();
        location1.addSourcesLocation(shipment1);
        em.persist(shipment1);
        em.getTransaction().commit();

        // Fetching the location again to check if the relationship is established
        Location persistedLocation = em.find(Location.class, location1.getId());

        assertEquals(1, persistedLocation.getSourcesLocations().size());
        assertTrue(persistedLocation.getSourcesLocations().contains(shipment1));
        assertEquals(location1, shipment1.getSourcesLocation());
    }

    @Test
    void addDestinationLocation() {
        EntityManager em = emf.createEntityManager();
        Shipment shipment2 = new Shipment();

        // Adding a shipment as a destination location
        em.getTransaction().begin();
        location2.addDestinationLocation(shipment2);
        em.persist(shipment2);
        em.getTransaction().commit();

        // Fetching the location again to check if the relationship is established
        Location persistedLocation = em.find(Location.class, location2.getId());

        assertEquals(1, persistedLocation.getDestinationsLocations().size());
        assertTrue(persistedLocation.getDestinationsLocations().contains(shipment2));
        assertEquals(location2, shipment2.getDestinationsLocation());
    }
}
