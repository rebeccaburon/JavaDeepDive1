package app.Uge2.FridayExcercie_Uge2OG3.DAO;

import app.Uge2.FridayExcercie_Uge2OG3.entities.Shipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShipmentDAO {

    private EntityManagerFactory emf;

    public ShipmentDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Shipment getShipmentById(Integer id) {
        try(EntityManager em = emf.createEntityManager()){
            return em.find(Shipment.class, id);
        }
    }

    public Shipment createShipment(Shipment shipment) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(shipment);
            em.getTransaction().commit();
        }
        return shipment;
    }
    public Set<Shipment> getAllShipments() {
        try (EntityManager em = emf.createEntityManager()){
            TypedQuery q = em.createQuery("SELECT s FROM Shipment s", Shipment.class);
            List<Shipment> shipments = q.getResultList();
            return shipments.stream()
                    .collect(Collectors.toSet());
        }
    }

    public Shipment updateShipment(Shipment shipment) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.merge(shipment);
            em.getTransaction().commit();

        }
        return shipment;
    }
    public Shipment deleteShipment(Shipment shipment) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(shipment);
            em.getTransaction().commit();

        }
        return shipment;
    }
}
