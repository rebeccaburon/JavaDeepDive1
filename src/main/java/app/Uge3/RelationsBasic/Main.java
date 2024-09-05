package app.Uge3.RelationsBasic;

import app.Uge3.RelationsBasic.entitie.Fee;
import app.Uge3.RelationsBasic.entitie.Person;
import app.Uge3.RelationsBasic.entitie.PersonDetail;
import app.Uge3.RelationsBasic.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

        try (EntityManager em = emf.createEntityManager()) {

            //OneToOne
            Person p1 = new Person("Søren");
            PersonDetail pd1 = new PersonDetail("Danstruvej 6", "Copenhagen", 69, 2100);
            p1.addPersonDetails(pd1);

            //Adding fee to person, by getting a Person object and then adding a fee to the person.
            Fee f1 = new Fee(250, LocalDate.of(2002,4,10));
            Fee f2 = new Fee(1000, LocalDate.of(2023,9,17));

            p1.addFee(f1);
            p1.addFee(f2);

            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();



        }



    }
}
