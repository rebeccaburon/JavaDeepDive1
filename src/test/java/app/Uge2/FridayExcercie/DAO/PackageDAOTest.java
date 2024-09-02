package app.Uge2.FridayExcercie.DAO;

import app.Uge2.FridayExcercie.entities.GLSPackages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.Uge2.FridayExcercie.persistence.HibernateConfig;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PackageDAOTest {
    private static EntityManagerFactory emf;
    private static PackageDAO packageDAO;

    GLSPackages packages1, packages2, packages3;

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
        packages1 = new GLSPackages("87854","TEST1","TEST1", GLSPackages.DeliveryStatus.PENDING);
        packages2 = new GLSPackages("58796","TEST1","TEST1", GLSPackages.DeliveryStatus.PENDING);
        packages3 = new GLSPackages("65946","TEST1","TEST1", GLSPackages.DeliveryStatus.PENDING);
        em.getTransaction().begin();
        em.createQuery("DELETE FROM GLSPackages").executeUpdate();
        em.persist(packages1);
        em.persist(packages2);
        em.persist(packages3);
        em.getTransaction().commit();
    }




    @Test
    void create() {
        //Arrange
        GLSPackages actualPackage = new GLSPackages("86540","Birgitte Hansen", "Hans Pedersen", GLSPackages.DeliveryStatus.DELIVERED);

        //Act
        GLSPackages expectedPackage = packageDAO.create(actualPackage);

        //Assert
        assertNotNull (expectedPackage);
        assertEquals(expectedPackage, actualPackage);
    }


    @Test
    public void testGetAll() {
        // Arrange
        Set<GLSPackages> packagesSet = packageDAO.getAll();

        // Assert
        assertNotNull(packagesSet);

        // Assert
        assertFalse(packagesSet.isEmpty());

        // Assert
        for (GLSPackages pkg : packagesSet) {
            assertNotNull(pkg);
        }
    }

    @Test
    void update() {
        //Arrange
        GLSPackages actualUpdate = packages2;

        //Act
        GLSPackages expectedUpdate = packageDAO.update(actualUpdate);

        //Assert
        assertNotNull(expectedUpdate);
        assertEquals(expectedUpdate, actualUpdate);
    }

    @Test
    void delete() {
        //Arrange
        GLSPackages actualDelete = packages3;

        //Act
        GLSPackages expectedDelete = packageDAO.delete(actualDelete);

        //Assert
        assertNotNull(expectedDelete);
        assertEquals(expectedDelete, actualDelete);

    }
}