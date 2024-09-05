package app.Uge3.Relations_Thomas_example.dao;

public interface IDAO <T> {
    void create(T t);
    T getById(int id);

}
