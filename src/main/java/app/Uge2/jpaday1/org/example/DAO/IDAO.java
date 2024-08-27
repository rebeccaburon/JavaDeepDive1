package app.Uge2.jpaday1.org.example.DAO;

import app.Uge2.jpaday1.org.example.entities.User;

import java.util.Set;

public interface IDAO<T> {
    T getId(Integer id);

    Set<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
