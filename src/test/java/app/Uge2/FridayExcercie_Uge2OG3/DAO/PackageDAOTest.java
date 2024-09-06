package app.Uge2.FridayExcercie_Uge2OG3.DAO;

import app.Uge2.FridayExcercie_Uge2OG3.entities.Packages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.Uge2.FridayExcercie_Uge2OG3.persistence.HibernateConfig;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PackageDAOTest {
    private static EntityManagerFactory emf;
    private static PackageDAO packageDAO;

    Packages packages1, packages2, packages3;

    @BeforeAll
    static void setUpAll() {
        HibernateConfig.setTestMode(true);
        emf = HibernateConfig.getEntityManagerFactory();
        packageDAO = new PackageDAO(emf);
    }

    @AfterAll
    static void tearDownAll() {
        HibernateConfig.setTestMode(false);
    }

    @BeforeEach
    void setUp(){
        EntityManager em = emf.createEntityManager();
        packages1 = new Packages("87854","TEST1","TEST1", Packages.DeliveryStatus.PENDING);
        packages2 = new Packages("58796","TEST1","TEST1", Packages.DeliveryStatus.PENDING);
        packages3 = new Packages("65946","TEST1","TEST1", Packages.DeliveryStatus.PENDING);
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Packages").executeUpdate();
        em.persist(packages1);
        em.persist(packages2);
        em.persist(packages3);
        em.getTransaction().commit();
    }




    @Test
    void create() {
        //Arrange
        Packages actualPackage = new Packages("86540","Birgitte Hansen", "Hans Pedersen", Packages.DeliveryStatus.DELIVERED);

        //Act
        Packages expectedPackage = packageDAO.create(actualPackage);

        //Assert
        assertNotNull (expectedPackage);
        assertEquals(expectedPackage, actualPackage);
    }


    @Test
    public void testGetAll() {
        // Arrange
        Set<Packages> packagesSet = packageDAO.getAll();

        // Assert
        assertNotNull(packagesSet);

        // Assert
        assertFalse(packagesSet.isEmpty());

        // Assert
        for (Packages pkg : packagesSet) {
            assertNotNull(pkg);
        }
    }

    @Test
    void update() {
        //Arrange
        Packages actualUpdate = packages2;

        //Act
        Packages expectedUpdate = packageDAO.update(actualUpdate);

        //Assert
        assertNotNull(expectedUpdate);
        assertEquals(expectedUpdate, actualUpdate);
    }

    @Test
    void delete() {
        //Arrange
        Packages actualDelete = packages3;

        //Act
        Packages expectedDelete = packageDAO.delete(actualDelete);

        //Assert
        assertNotNull(expectedDelete);
        assertEquals(expectedDelete, actualDelete);

    }
}