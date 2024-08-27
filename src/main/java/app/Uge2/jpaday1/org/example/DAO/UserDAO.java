package app.Uge2.jpaday1.org.example.DAO;

import app.Uge2.jpaday1.org.example.entities.User;
import app.Uge2.jpaday1.org.example.persistence.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDAO implements IDAO<User> {
    //Adgang til databasen, når vi har et objekt af Enitity manger
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();


    @Override
    public User getId(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {

            return em.find(User.class, id);
        }
    }

    @Override
    public Set<User> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            //
            TypedQuery<User> query = em.createQuery("select u from User u", User.class);
            List<User> userelist = query.getResultList();
            return userelist.stream().collect(Collectors.toSet());
        }
    }

    @Override
    public void create(User user) {
        //Try with resoureces
        try (EntityManager em = emf.createEntityManager()) {
            // Når man skal ændre noget i databasen
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }

    @Override
    public void update(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }

    }

    @Override
    public void delete(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        userDAO.create(User
                .builder()
                .username("RebeccaErSej")
                .password("1234")
                .email("Rebecca@sej.dk")
                .build()
        );


        // userDAO.update(new User(1, "Hejssa", "LOL", "Totalt"));


       // userDAO.delete(new User(1, "Hejssa", "LOL", "Totalt"));

        System.out.println( userDAO.getId(2));

        userDAO.getAll().forEach(System.out::println);

    }

}
