package app.Uge3.RelationsBasic;

import app.Uge3.RelationsBasic.entitie.Event;
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
            Person p1 = new Person("Lisa");
            PersonDetail pd1 = new PersonDetail("Åblouevarden 4", "Copenhagen", 74, 2420);
            p1.addPersonDetails(pd1);

            //Adding fee to person, by getting a Person object and then adding a fee to the person.
            Fee f1 = new Fee(250, LocalDate.of(2002,4,10));
            Fee f2 = new Fee(1000, LocalDate.of(2023,9,17));

            p1.addFee(f1);
            p1.addFee(f2);

            Event e1 = new Event(LocalDate.of(2004, 12,20),"DM Senior");
            Event e2 = new Event(LocalDate.of(2006, 5,8), "SM Unior");
//            p1.addEvent(e1);
//            p1.addEvent(e2);

            //Adding event with via a Linked Tabel being the PersonEvent
            p1.addEvent(p1,e1,LocalDate.of(2023, 9,21), 120);
            p1.addEvent(p1,e1,LocalDate.of(2003, 6,10), 500);

            //adding ID til event - and making sure it god Manged
            em.persist(e1);
            em.persist(e2);




            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();



        }



    }
}
